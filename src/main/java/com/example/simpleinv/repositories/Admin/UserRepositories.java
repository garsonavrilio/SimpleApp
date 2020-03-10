package com.example.simpleinv.repositories.Admin;

import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
import com.example.simpleinv.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends CrudRepository<User, Integer> {
  Optional<User> findUserByUsername(String username);

  @Query(value = "SELECT u FROM User u WHERE u.username = ?1")
  User findByUsername(String name);

  boolean existsByUsername(String username);
}
