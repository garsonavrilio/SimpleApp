package com.example.simpleinv.services.token.impl;

import com.example.simpleinv.dto.TokenDTO.TokenDTO;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.User;
import com.example.simpleinv.repositories.Admin.UserRepositories;
import com.example.simpleinv.repositories.Role.RoleRepositories;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.token.TokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  public static final long TOKEN_VALIDITY = 5 * 60 * 60;

  @Value("${expired.time}")
  Integer expiredDate;

  public Date getExpiredDate() {
    return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * expiredDate);
  }

  @Autowired
  RedisTemplate<String, String> redisTemplate;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  UserRepositories userRepo;

  @Autowired
  RoleRepositories roleRepo;

  @Autowired
  PermissionService permissionService;

  @Override
  public boolean tokenValid(String token) throws JsonProcessingException {
    String json = redisTemplate.opsForValue().get("Token: " + token);
    if (json.isEmpty()) {
      throw new BadCredentialsException("Value in token is empty");
    }
    TokenDTO tokenDTO = objectMapper.readValue(json, TokenDTO.class);
    if (tokenDTO.getCreatedAt().after(new Date()) || tokenDTO.getExpiredAt().before(new Date())) {
      return false;
    }
    return true;
  }

  @Override
  public TokenDTO getDetailsByToken(String token) throws JsonProcessingException {
    String json = redisTemplate.opsForValue().get("Token: " + token);
    if (json.isEmpty()) {
      throw new BadCredentialsException("Value in token is empty");
    }
    return objectMapper.readValue(json, TokenDTO.class);
  }

  @Override
  public boolean tokenController(String token, String url) throws JsonProcessingException {
    TokenDTO userToken = getDetailsByToken(token);
    if (userToken.getCreatedAt().after(new Date()) || userToken.getExpiredAt().before(new Date())) {
      throw new BadCredentialsException("Your Token has Expired...");
    } else {
      Optional<User> userOptional = userRepo.findById(userToken.getId());
      User user = userOptional
          .orElseThrow(() -> new IllegalArgumentException("TokenAcceptedRole : User not found"));
      Optional<Role> roleOptional = roleRepo.findRolesByRoleName(user.getRole());
      Role role = roleOptional
          .orElseThrow(() -> new IllegalArgumentException("TokenAccepetedRole : Role not found"));
      List<Integer> rolesId = permissionService.rolePermission(role.getRoleId());
      Integer urlId = permissionService.searchUrlId(url);
      return rolesId.contains(urlId);
    }
  }
}
