package com.example.simpleinv.controller;

import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
import com.example.simpleinv.dto.UserRoleDTO.UserRoleResponseDTO;
import com.example.simpleinv.model.Role_Permission;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.permissionrole.PermissionRoleService;
import com.example.simpleinv.services.user.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @Autowired
  PermissionRoleService permissionRoleService;

  @Autowired
  PermissionService permissionService;

  @RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = "application/json")
  public List<UserResponseDTO> getAllUser(@RequestHeader(value = "Authorization") String token) {
    String username = permissionService.getUsernameByToken(token);
    Integer roleId = permissionService.getRoleByUsername(username);
    List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
    Integer url = permissionService.searchUrlId("/user/all");
    boolean flag = listOfRolePermission.contains(url);
      if (flag) {
          return userService.getAllUser(token);
      } else {
          throw new IllegalArgumentException("You Do Not have Permission to continue this process");
      }
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
  public UserResponseDTO findUserId(@RequestHeader(value = "Authorization") String token,
      @PathVariable Integer id) {
      String username = permissionService.getUsernameByToken(token);
      Integer roleId = permissionService.getRoleByUsername(username);
      List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
      Integer url = permissionService.searchUrlId("/user/{id}");
      boolean flag = listOfRolePermission.contains(url);
      if (flag) {
          return userService.findUserId(id);
      } else {
          throw new IllegalArgumentException("You Do Not have Permission to continue this process");
      }
  }
//
//    @RequestMapping(value = "/user/roles", method = RequestMethod.GET, produces = "appplication/json")
//    public List<UserRoleResponseDTO> getAllUserWithRoles(){
//
//    }

  @RequestMapping(value = "/user/update/{id}", method = RequestMethod.PUT,
      produces = "application/json")
  public UserResponseDTO updateUser(@RequestHeader(value = "Authorization") String token,
      @PathVariable Integer id, @RequestBody UserRequestDTO request) {

      String username = permissionService.getUsernameByToken(token);
      Integer roleId = permissionService.getRoleByUsername(username);
      List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
      Integer url = permissionService.searchUrlId("/user/update/{id}");
      boolean flag = listOfRolePermission.contains(url);
      if (flag) {
          return userService.updateUser(id, request);
      } else {
          throw new IllegalArgumentException("You Do Not have Permission to continue this process");
      }
  }

  @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE,
      produces = "application/json")
  public UserResponseDTO deleteUser(@RequestHeader(value = "Authorization") String token,
      @PathVariable Integer id) {
      String username = permissionService.getUsernameByToken(token);
      Integer roleId = permissionService.getRoleByUsername(username);
      List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
      Integer url = permissionService.searchUrlId("/user/delete/{id}");
      boolean flag = listOfRolePermission.contains(url);
      if (flag) {
          return userService.deleteUser(id);
      } else {
          throw new IllegalArgumentException("You Do Not have Permission to continue this process");
      }
  }

  @RequestMapping(value = "/user/sign-up", method = RequestMethod.POST,
      produces = "application/json")
  public UserResponseDTO createUser(@RequestBody UserRequestDTO request) {
    //equest.set
    return userService.createUser(request);
  }

  @RequestMapping(value = "/helloworld", method = RequestMethod.GET,produces = "application/json")
  public String print(){
    return "Hello World";
  }
}
