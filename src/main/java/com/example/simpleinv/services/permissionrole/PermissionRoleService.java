package com.example.simpleinv.services.permissionrole;

import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import com.example.simpleinv.model.Role_Permission;
import java.util.List;

public interface PermissionRoleService {
  List<PermissionRoleResponseDTO> getAllRolePermission();
}
