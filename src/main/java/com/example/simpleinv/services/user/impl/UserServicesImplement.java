package com.example.simpleinv.services.user.impl;

//import com.example.simpleinv.config.JwtTokenUtil;
import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
import com.example.simpleinv.dto.UserDTO.converter.UserRequestToUserConverter;
import com.example.simpleinv.dto.UserDTO.converter.UserToResponseConverter;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.User;
import com.example.simpleinv.model.User_Role;
import com.example.simpleinv.repositories.Admin.UserRepositories;
import com.example.simpleinv.repositories.Role.RoleRepositories;
import com.example.simpleinv.repositories.User_Role.UserRole_Repositories;
import com.example.simpleinv.services.user.UserService;
import com.example.simpleinv.services.userrole.UserRoleService;
import java.util.Arrays;
import java.util.Collections;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.NotFound;

@Service
public class UserServicesImplement implements UserService {

  @Autowired
  UserRepositories userRepo;

  @Autowired
  UserRole_Repositories userRole_repositories;

  @Autowired
  RoleRepositories roleRepositories;

  @Autowired
  UserRoleService userRoleService;

  @Autowired
  PasswordEncoder passwordEncoder;

//  @Autowired
//  JwtTokenUtil jwtTokenUtil;

  @Override
  public List<UserResponseDTO> getAllUser(String token) {
//    final String token = request.getHeader("Authorization");
//    String username = null;
//    String username = null;
//    String jwtToken = null;
//    jwtToken = token.substring(7);
//    username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//    System.out.println(username);
//    username = jwtTokenUtil.getUsernameFromToken(token);
//    System.out.println(username);
    return StreamSupport.stream(userRepo.findAll().spliterator(), false)
        .map(UserToResponseConverter::convert).collect(Collectors.toList());
  }

  @Override
  public UserResponseDTO findUserId(Integer id) {
    Optional<User> user = userRepo.findById(id);
    if (user.isPresent()) {
      return UserToResponseConverter.convert(user.get());
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public UserResponseDTO updateUser(Integer id, UserRequestDTO request) {
    Optional<User_Role> optionalUserRole = userRole_repositories.findByUserId(id);
    User_Role userRoleToBeUpdated = optionalUserRole
        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id"));

    Optional<Role> optionalRole = roleRepositories.findRolesByRoleName(request.getRole());
    Role newRole = optionalRole.orElseThrow(() -> new IllegalArgumentException("Invalid Role"));
    userRoleToBeUpdated.setUserName(request.getUsername());
    userRoleToBeUpdated.setRoleId(newRole.getRoleId());
    userRole_repositories.save(userRoleToBeUpdated);

    User temp = UserRequestToUserConverter.convertUpdate(request);
    temp.setUserId(id);
    temp.setPassword(passwordEncoder.encode(request.getPassword()));
    return UserToResponseConverter.convert(userRepo.save(temp));
  }

  @Override
  public UserResponseDTO deleteUser(Integer Id) {
    boolean flag = userRepo.existsById(Id);
    if (flag) {
      Optional<User> temp = userRepo.findById(Id);
      userRepo.deleteById(Id);
      return temp.map(UserToResponseConverter::convert).orElse(null);
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public UserResponseDTO createUser(UserRequestDTO request) {
    boolean flag = userRepo.existsByUsername(request.getUsername());
    if(flag) throw new IllegalArgumentException("Username is already Exist");

    User user = UserRequestToUserConverter.convertCreate(request);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    System.out.println(user.getPassword());

    if (request.getRole().isEmpty()) {
      user.setRole("CASHIER");
    } else {
      Optional<Role> role = roleRepositories.findRolesByRoleName(request.getRole());
      Role newRole = role.orElseThrow(() -> new IllegalArgumentException("Invalid role"));
      user.setRole(newRole.getRoleName());
    }

    user = userRepo.save(user);

    Optional<User_Role> userRoles = userRole_repositories.findById(user.getUserId());
    System.out.println(userRoles);
    if (userRoles.isPresent()) {
      User_Role userRole = userRoles.get();
      throw new IllegalArgumentException("ISI UPDATE DISINI");


    } else {
      User_Role user_role = new User_Role();
      user_role.setUserId(user.getUserId());
      user_role.setRoleId(3);
      user_role.setUserName(user.getUsername());
      userRole_repositories.save(user_role);
      return UserToResponseConverter.convert(user);
    }

//        if(userRole.isEmpty()){
//            Optional<Role> optionalRole = roleRepositories.findRolesByRoleName("CASHIER");
//            Role defaultRole = optionalRole.orElseThrow(()-> new ExpressionException("Role not found"));
//            List<User_Role> userRoles = Collections
//                .singletonList(User_Role.builder().user(user).role(defaultRole).build());
//
//            user.setUser_roles(userRoles);
//        }

    //return UserToResponseConverter.convert(userRepo.save(user));
  }

  @Override
  public User getUserByUsername(String username) {
    //Optional<UserResponseDTO> optionalUser = userRepo.findUserByUsername(username);
    //User user1 = optionalUser.orElseThrow(() -> new IllegalArgumentException("find by username not found!"));
    //User user1 = userRepo.findByUsername(username);
    return userRepo.findByUsername(username);
  }
}
