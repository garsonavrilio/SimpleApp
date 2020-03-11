package com.example.simpleinv.services.login.impl;

import com.example.simpleinv.dto.LoginDTO.UserLoginDTO;
import com.example.simpleinv.dto.TokenDTO.TokenDTO;
import com.example.simpleinv.model.User;
import com.example.simpleinv.repositories.Admin.UserRepositories;
import com.example.simpleinv.services.login.LoginService;
import com.example.simpleinv.services.token.TokenService;
import com.example.simpleinv.services.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  public final static long TOKEN_VALIDITY = 5 * 60 * 60;

  @Value("${expired.time}")
  Integer expiredDate;

  public Date getExpiredDate(){
    return new Date(System.currentTimeMillis()+TOKEN_VALIDITY * expiredDate);
  }

  @Autowired
  UserRepositories userRepo;

  @Autowired
  TokenService tokenService;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  RedisTemplate<String,String> redisTemplate;

  @Autowired
  ObjectMapper objectMapper;

  boolean enableLogin = false;

  public boolean isEnableLogin(){
    return enableLogin;
  }

  @Override
  public ResponseEntity<?> loginService(UserLoginDTO userLoginDTO) throws IOException {

    String loginUsername = userLoginDTO.getUsername();
    String loginPassword = userLoginDTO.getPassword();

    boolean flag = userRepo.existsByUsername(loginUsername);
    if (flag) {
      User user = userRepo.findByUsername(loginUsername);
      if (passwordEncoder.matches(loginPassword, user.getPassword())) {
        enableLogin = true;
        UUID uuid = UUID.randomUUID();
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setId(user.getUserId());
        tokenDTO.setCreatedAt(new Date());
        tokenDTO.setExpiredAt(getExpiredDate());
        final String token = uuid.toString();
        String json = objectMapper.writeValueAsString(tokenDTO);
        redisTemplate.opsForValue().set("Token: "+token,json);
        boolean flag2 = tokenService.tokenValid(token);
        System.out.println(tokenDTO.getExpiredAt());
        System.out.println(tokenDTO.getCreatedAt());
        System.out.println(new Date());
        System.out.println(flag2);
        return new ResponseEntity<>(token, HttpStatus.OK);
      } else return new ResponseEntity<>("Invalid Password",HttpStatus.BAD_REQUEST);
    } else return new ResponseEntity<>("Invalid Username and Password",HttpStatus.BAD_REQUEST);
  }
}
