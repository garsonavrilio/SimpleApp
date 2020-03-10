//package com.example.simpleinv.controller;
//
//import com.example.simpleinv.config.JwtTokenUtil;
//import com.example.simpleinv.dto.LoginDTO.UserLoginDTO;
//import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
//import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
//import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
//import com.example.simpleinv.model.User;
//import com.example.simpleinv.services.auth.JwtAuthenticationManager;
//import com.example.simpleinv.services.permissionrole.PermissionRoleService;
//import com.example.simpleinv.services.user.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//public class JwtAuthenticationController {
//
//  @Autowired
//  RedisTemplate<String, String> redisTemplate;
//
//  @Autowired
//  ObjectMapper objectMapper;
//
//  @Autowired
//  JwtAuthenticationManager jwtAuthenticationManager;
//
//  @Autowired
//  JwtTokenUtil jwtTokenUtil;
//
//  @Autowired
//  private UserService userService;
//
//  @Autowired
//  PermissionRoleService permissionRoleService;
//
//  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//  public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginDTO request) throws Exception {
//    System.out.println("Masuk Controller");
//    System.out.println(request.getUsername());
//    System.out.println(request.getPassword());
//
////    List<PermissionRoleResponseDTO> iseng = permissionRoleService.getAllRolePermission();
////    System.out.println(iseng);
//
//    authenticate(request.getUsername(), request.getPassword());
//    System.out.println(jwtAuthenticationManager.flag());
//
//    if(jwtAuthenticationManager.flag()) {
//      //Ngambil data user sesuai dengan username
//      User userDetails = userService.getUserByUsername(request.getUsername());
//      System.out.println(userDetails);
//      //Generate Token untuk entity user bedasarkan username;
//      final String token = jwtTokenUtil.generateToken(userDetails);
//      String json = objectMapper.writeValueAsString(userDetails);
//      redisTemplate.opsForValue().set("Token:" +token,json);
//      System.out.println(token);
//      return new ResponseEntity<>(token, HttpStatus.OK);
//    }
//    else{
//
//      return new ResponseEntity<>("Password is Invalid",HttpStatus.NOT_ACCEPTABLE);
//    }
//
//  }
//
//  private void authenticate(String username, String password) throws Exception {
//    try {
//      System.out.println("masuk authenticate controller");
//      jwtAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//      System.out.println("masuk authenticate controller2");
//    } catch (DisabledException e) {
//      throw new Exception("User_Disabled", e);
//    } catch (BadCredentialsException e) {
//      throw new Exception("Invalid_Credentials", e);
//    }
//   // return auth;
//  }
//
//}


