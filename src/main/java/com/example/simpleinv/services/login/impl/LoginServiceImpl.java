package com.example.simpleinv.services.login.impl;

import com.example.simpleinv.dto.LoginDTO.UserLoginDTO;
import com.example.simpleinv.dto.TokenDTO.TokenDTO;
import com.example.simpleinv.model.User;
import com.example.simpleinv.repositories.Admin.UserRepositories;
import com.example.simpleinv.services.login.LoginService;
import com.example.simpleinv.services.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  UserRepositories userRepo;

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
  public ResponseEntity<?> loginService(UserLoginDTO userLoginDTO) throws JsonProcessingException {

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
        final String token = uuid.toString();
        String json = objectMapper.writeValueAsString(tokenDTO);
        redisTemplate.opsForValue().set("Token: "+token,json);
        return new ResponseEntity<>(token, HttpStatus.OK);
      } else return new ResponseEntity<>("Invalid Password",HttpStatus.BAD_REQUEST);
    } else return new ResponseEntity<>("Invalid Username and Password",HttpStatus.BAD_REQUEST);
  }
}
