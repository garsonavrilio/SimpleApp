package com.example.simpleinv.controller;

import com.example.simpleinv.dto.TokenDTO.TokenDTO;
import com.example.simpleinv.dto.UserDTO.UpdateUserDTO;
import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
import com.example.simpleinv.services.token.TokenService;
import com.example.simpleinv.services.user.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  TokenService tokenService;

  @Autowired
  UserService userService;

  @RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = "application/json")
  public List<UserResponseDTO> getAllUser(@RequestHeader(value = "Authorization") String token)
      throws JsonProcessingException {
    String url = "/user/all";
    boolean flag = tokenService.tokenController(token, url);
    if (flag) {
      return userService.getAllUser(token);
    } else {
      throw new BadCredentialsException("You Do Not have Permission to continue this process");
    }
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
  public UserResponseDTO findUserId(@RequestHeader(value = "Authorization") String token,
      @PathVariable Integer id) throws JsonProcessingException {
    String url = "/user/{id}";
    boolean flag = tokenService.tokenController(token, url);
    if (flag) {
      return userService.findUserId(id);
    } else {
      throw new BadCredentialsException("You Do Not have Permission to continue this process");
    }
  }

  @RequestMapping(value = "/user/update/", method = RequestMethod.PUT,
      produces = "application/json")
  public UserResponseDTO updateUser(@RequestHeader(value = "Authorization") String token,
       @RequestBody UserRequestDTO request)
      throws JsonProcessingException {
    String url = "/user/update/";
    //TokenDTO userToken = tokenService.getDetailsByToken(token);
    boolean flag = tokenService.tokenController(token, url);
    if (flag) {
      return userService.updateUser(token, request);
    } else {
      throw new BadCredentialsException("You Do Not have Permission to continue this process");
    }
  }

  @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE,
      produces = "application/json")
  public UserResponseDTO deleteUser(@RequestHeader(value = "Authorization") String token,
      @PathVariable Integer id) throws JsonProcessingException {
    String url = "/user/delete/{id}";
    boolean flag = tokenService.tokenController(token, url);
    if (flag) {
      return userService.deleteUser(id);
    } else {
      throw new BadCredentialsException("You Do Not have Permission to continue this process");
    }
  }

  @RequestMapping(value = "/user/create", method = RequestMethod.POST,
      produces = "application/json")
  public UserResponseDTO createUser(@RequestBody UserRequestDTO request) {
    return userService.createUser(request);
  }

  @RequestMapping(value = "/admin/sign-up", method = RequestMethod.POST,produces = "application/json")
  public UserResponseDTO createAdmin(@RequestBody UserRequestDTO request){
    return userService.createAdmin(request);
  }

}
