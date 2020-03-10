package com.example.simpleinv.repositories.Permission_Role;

import com.example.simpleinv.model.Role_Permission;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRoleRepositories extends CrudRepository<Role_Permission, Integer> {
  List<Role_Permission> findAllByRoleId (Integer id);
}
