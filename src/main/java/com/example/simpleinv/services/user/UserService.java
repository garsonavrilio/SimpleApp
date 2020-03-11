package com.example.simpleinv.services.user;

import com.example.simpleinv.dto.UserDTO.UpdateUserDTO;
import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
import com.example.simpleinv.dto.UserDTO.UserResponseDTO;

import com.example.simpleinv.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    List<UserResponseDTO> getAllUser(String token);
    UserResponseDTO findUserId(Integer id);
    UserResponseDTO updateUser(String token, UserRequestDTO request) throws JsonProcessingException;
    UserResponseDTO deleteUser(Integer id);
    UserResponseDTO createUser(UserRequestDTO request);
    UserResponseDTO createAdmin(UserRequestDTO request);
    User getUserByUsername(String username);
}
