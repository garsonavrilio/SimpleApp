package com.example.simpleinv.repositories.Role;

import com.example.simpleinv.model.Role;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepositories extends JpaRepository<Role,Integer> {
  Optional<Role> findRolesByRoleName(String name);


}
