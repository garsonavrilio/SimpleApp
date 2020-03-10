package com.example.simpleinv.dto.UserDTO;

import com.example.simpleinv.model.User_Role;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UserRequestDTO {
    private Integer userId;
    private String username;
    private String password;
    private String fullname;
    private String gender;
    private String role;
    //private List<User_Role> user_roles;
}
