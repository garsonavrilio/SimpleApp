package com.example.simpleinv.services.login;

import com.example.simpleinv.dto.LoginDTO.UserLoginDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
  ResponseEntity<?> loginService(UserLoginDTO userLoginDTO) throws JsonProcessingException;
}
