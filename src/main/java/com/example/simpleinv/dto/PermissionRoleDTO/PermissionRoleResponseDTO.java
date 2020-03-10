package com.example.simpleinv.dto.PermissionRoleDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PermissionRoleResponseDTO {

  public PermissionRoleResponseDTO(Integer rolePermissionId, Integer roleId, Integer permissionId){
    this.rolePermissionId = rolePermissionId;
    this.roleId = roleId;
    this.permissionId = permissionId;
  }

  private Integer rolePermissionId;
  private Integer roleId;
  private Integer permissionId;
}
