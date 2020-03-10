package com.example.simpleinv.dto.PermissionRoleDTO.converter;

import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import com.example.simpleinv.model.Role_Permission;

public class PermissionRoleToResponseConverter {

  public static PermissionRoleResponseDTO convert (Role_Permission rp){
    return new PermissionRoleResponseDTO(rp.getRolePermissionId(),rp.getRoleId(),rp.getPermissionId());
  }

}
