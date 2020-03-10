package com.example.simpleinv.repositories.Permission;

import com.example.simpleinv.model.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepositories extends CrudRepository<Permission, Integer> {

  @Query("SELECT p.permission_id FROM Permission p WHERE p.name = ?1")
  Integer getUrlId(String name);
}
