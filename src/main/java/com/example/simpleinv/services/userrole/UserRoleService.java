package com.example.simpleinv.services.userrole;

import com.example.simpleinv.dto.UserRoleDTO.UserRoleResponseDTO;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.User_Role;
import java.util.List;

public interface UserRoleService {
  //Role getRolesById(Integer Id);
  //UserRoleResponseDTO findByName(String name);
  Integer getRoleByUsername(String username);
}
