package com.example.simpleinv.controller;

import com.example.simpleinv.dto.LoginDTO.UserLoginDTO;
import com.example.simpleinv.services.login.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @Autowired
  LoginService loginService;

  @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json")
  public ResponseEntity<?> login (@RequestBody UserLoginDTO userLoginDTO)
      throws JsonProcessingException {
    return loginService.loginService(userLoginDTO);
  }
}
