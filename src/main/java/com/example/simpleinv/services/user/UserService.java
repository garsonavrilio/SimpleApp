package com.example.simpleinv.services.user;

import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
import com.example.simpleinv.dto.UserDTO.UserResponseDTO;

import com.example.simpleinv.model.User;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    List<UserResponseDTO> getAllUser(String token);
    UserResponseDTO findUserId(Integer id);
    UserResponseDTO updateUser(Integer id, UserRequestDTO request);
    UserResponseDTO deleteUser(Integer id);
    UserResponseDTO createUser(UserRequestDTO request);
    User getUserByUsername(String username);
}
