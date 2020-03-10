package com.example.simpleinv.dto.UserDTO.converter;

import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.User;
import com.example.simpleinv.model.User_Role;
import java.util.ArrayList;
import java.util.List;

public class UserToResponseConverter {

  public static UserResponseDTO convert(User user) {
//    List<String> roles = new ArrayList<>();
//    for (User_Role role : user.getUser_roles()) {
//      roles.add(role.getRole().getRoleName());
//    }

    return new UserResponseDTO(
        user.getUserId(), user.getUsername(), user.getPassword(),
        user.getFullname(), user.getGender(), user.getRole()
        //roles
    );
  }
}
