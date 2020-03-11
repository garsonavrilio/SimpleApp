package com.example.simpleinv.services.user.impl;

//import com.example.simpleinv.config.JwtTokenUtil;
import com.example.simpleinv.dto.TokenDTO.TokenDTO;
import com.example.simpleinv.dto.UserDTO.UpdateUserDTO;
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
import com.example.simpleinv.services.token.TokenService;
import com.example.simpleinv.services.user.UserService;
import com.example.simpleinv.services.userrole.UserRoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.org.apache.bcel.internal.generic.ATHROW;
import java.util.Arrays;
import java.util.Collections;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.authentication.BadCredentialsException;
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

  @Autowired
  TokenService tokenService;

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
  public UserResponseDTO updateUser(String token, UserRequestDTO request)
      throws JsonProcessingException {
    TokenDTO userToken = tokenService.getDetailsByToken(token);
    Optional<User_Role> optionalUserRole = userRole_repositories.findByUserId(userToken.getId());
    User_Role userRoleToBeUpdated = optionalUserRole.orElseThrow(() -> new IllegalArgumentException("Invalid user Id"));
    Optional<Role> opRole = roleRepositories.findById(userRoleToBeUpdated.getRoleId());
    Role roleUpdate = opRole.orElseThrow(()-> new IllegalArgumentException("Cannot find role"));


    if(userRoleToBeUpdated.getRoleId()==2) {

      Optional<Role> optionalRole = roleRepositories.findRolesByRoleName(request.getRole());
      Role newRole = optionalRole.orElseThrow(() -> new IllegalArgumentException("Invalid Role"));
      userRoleToBeUpdated.setUserName(request.getUsername());
      userRoleToBeUpdated.setRoleId(newRole.getRoleId());
      userRole_repositories.save(userRoleToBeUpdated);

      User temp = UserRequestToUserConverter.convertUpdate(request);
      temp.setUserId(userToken.getId());
      temp.setPassword(passwordEncoder.encode(request.getPassword()));
      return UserToResponseConverter.convert(userRepo.save(temp));
    }
    else if (userRoleToBeUpdated.getRoleId()==1 || userRoleToBeUpdated.getRoleId()==3){
      //Optional<Role> optionalRole = roleRepositories.findRolesByRoleName(request.getRole());
      //Role newRole = optionalRole.orElseThrow(() -> new IllegalArgumentException("Invalid Role"));
      userRoleToBeUpdated.setUserName(request.getUsername());
      userRoleToBeUpdated.setRoleId(userRoleToBeUpdated.getUserRoleId());
      userRole_repositories.save(userRoleToBeUpdated);

      request.setRole(roleUpdate.getRoleName());
      User temp = UserRequestToUserConverter.convertUpdate(request);
      temp.setUserId(userToken.getId());
      temp.setPassword(passwordEncoder.encode(request.getPassword()));
      return UserToResponseConverter.convert(userRepo.save(temp));
    }
    else throw new BadCredentialsException("HAHAHAH RUSAK");
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
    if (request.getRole().isEmpty()) {
      Optional<Role> roleOptional = roleRepositories.findRolesByRoleName(request.getDefaultRole());
      Role role = roleOptional.orElseThrow(()-> new IllegalArgumentException("Cannot find Default Role"));
      user.setRole(role.getRoleName());
      userRepo.save(user);
      User_Role userRole = new User_Role();
      userRole.setUserName(user.getUsername());
      userRole.setRoleId(role.getRoleId());
      userRole.setUserId(user.getUserId());
      userRole_repositories.save(userRole);

      return UserToResponseConverter.convert(user);

    } else {
      Optional<Role> roleOptional = roleRepositories.findRolesByRoleName(request.getRole());
      Role role = roleOptional.orElseThrow(() -> new IllegalArgumentException("Invalid role"));
      user.setRole(role.getRoleName());
      userRepo.save(user);

      User_Role userRole = new User_Role();
      userRole.setUserName(user.getUsername());
      userRole.setRoleId(role.getRoleId());
      userRole.setUserId(user.getUserId());
      userRole_repositories.save(userRole);

      return UserToResponseConverter.convert(user);
    }

//    user = userRepo.save(user);
//
//    Optional<User_Role> userRoles = userRole_repositories.findById(user.getUserId());
//    System.out.println(userRoles);
//    if (userRoles.isPresent()) {
//      User_Role userRole = userRoles.get();
//      throw new IllegalArgumentException("ISI UPDATE DISINI");
//
//
//    } else {
//      User_Role user_role = new User_Role();
//      user_role.setUserId(user.getUserId());
//      user_role.setRoleId(3);
//      user_role.setUserName(user.getUsername());
//      userRole_repositories.save(user_role);
//      return UserToResponseConverter.convert(user);
//    }

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
  public UserResponseDTO createAdmin(UserRequestDTO request) {
    boolean flag = userRepo.existsByUsername(request.getUsername());
    if(flag) throw new IllegalArgumentException("Username is already Exist");

    User user = UserRequestToUserConverter.convertCreate(request);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
      Optional<Role> roleOptional = roleRepositories.findRolesByRoleName(request.getAdminRole());
      Role role = roleOptional.orElseThrow(() -> new IllegalArgumentException("Cannot find Admin Role"));
      user.setRole(role.getRoleName());
      userRepo.save(user);
      User_Role userRole = new User_Role();
      userRole.setUserName(user.getUsername());
      userRole.setRoleId(role.getRoleId());
      userRole.setUserId(user.getUserId());
      userRole_repositories.save(userRole);

      return UserToResponseConverter.convert(user);

  }

  @Override
  public User getUserByUsername(String username) {
    //Optional<UserResponseDTO> optionalUser = userRepo.findUserByUsername(username);
    //User user1 = optionalUser.orElseThrow(() -> new IllegalArgumentException("find by username not found!"));
    //User user1 = userRepo.findByUsername(username);
    return userRepo.findByUsername(username);
  }
}
