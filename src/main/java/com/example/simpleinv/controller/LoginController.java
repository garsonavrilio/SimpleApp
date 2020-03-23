package com.example.simpleinv.controller;

import com.example.simpleinv.dto.LoginDTO.UserLoginDTO;
import com.example.simpleinv.services.login.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "application/json")
@RestController
public class LoginController {

  @Autowired
  LoginService loginService;

  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
  public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) throws IOException {
    return loginService.loginService(userLoginDTO);
  }
}
