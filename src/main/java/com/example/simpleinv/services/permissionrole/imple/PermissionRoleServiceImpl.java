package com.example.simpleinv.services.permissionrole.imple;

import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import com.example.simpleinv.dto.PermissionRoleDTO.converter.PermissionRoleToResponseConverter;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.Role_Permission;
import com.example.simpleinv.repositories.Permission_Role.PermissionRoleRepositories;
import com.example.simpleinv.services.permissionrole.PermissionRoleService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

  @Autowired
  PermissionRoleRepositories permissionRoleRepositories;

  @Override
  public List<PermissionRoleResponseDTO> getAllRolePermission() {
    return StreamSupport.stream(permissionRoleRepositories.findAll().spliterator(),false)
        .map(PermissionRoleToResponseConverter::convert).collect(Collectors.toList());
  }
}
