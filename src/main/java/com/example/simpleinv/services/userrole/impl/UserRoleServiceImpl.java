package com.example.simpleinv.services.userrole.impl;

import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
import com.example.simpleinv.dto.UserRoleDTO.UserRoleResponseDTO;
//import com.example.simpleinv.dto.UserRoleDTO.converter.UserRoleToResponseConverter;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.User_Role;
import com.example.simpleinv.repositories.Role.RoleRepositories;
import com.example.simpleinv.repositories.User_Role.UserRole_Repositories;
import com.example.simpleinv.services.userrole.UserRoleService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

  @Autowired
  UserRole_Repositories userRoleRepo;

  @Autowired
  RoleRepositories roleRepo;

  @Override
  public Integer getRoleByUsername(String username) {
    return null;
  }

//  @Override
//  public Role getRolesById(Integer id) {
//    Optional<Role> role = roleRepo.findById(id);
//    return role.orElseThrow(()-> new IllegalArgumentException("Gaada isi role"));
//  }

//  @Override
//  public UserRoleResponseDTO findByName(String name) {
//    User_Role userRole= userRoleRepo.findByName(name);
//    return UserRoleToResponseConverter.convert(userRole);
//  }


}
