package com.example.simpleinv.dto.PermissionRoleDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PermissionRoleRequestDTO {
  private Integer rolePermissionId;
  private Integer roleId;
  private Integer permissionId;
}
