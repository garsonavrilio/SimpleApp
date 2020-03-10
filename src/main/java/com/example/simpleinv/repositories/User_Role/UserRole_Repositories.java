package com.example.simpleinv.repositories.User_Role;

import com.example.simpleinv.dto.UserRoleDTO.UserRoleResponseDTO;
import com.example.simpleinv.model.User_Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRole_Repositories extends CrudRepository<User_Role, Integer> {
//
//  @Query("SELECT u.username FROM User u WHERE u.username = ?1")
//  String getUsername(String name);
  //@Query("SELECT r.roleName FROM Role r INNER JOIN User_Role ur ON r.roleId = ur.userRoleId WHERE ur.")

  //@Query("SELECT u FROM User_Role u WHERE u.userName = ?1")
  //User_Role findByName(String name);

  @Query("SELECT u FROM User_Role  u WHERE u.userId = ?1")
  Optional<User_Role> findByUserId(Integer id);

}
