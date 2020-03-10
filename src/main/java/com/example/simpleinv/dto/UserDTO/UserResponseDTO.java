package com.example.simpleinv.dto.UserDTO;

import com.example.simpleinv.model.Role;
import com.example.simpleinv.model.User_Role;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UserResponseDTO implements Serializable {

    private static final long serialVersionUID = 3988481369490466459L;

    private Integer userId;
    private String username;
    private String password;
    private String fullname;
    private String gender;
    private String role;

    //private List<String> roles;

    public UserResponseDTO(
        Integer userId,
        String username,
        String password,
        String fullname,
        String gender ,
        String role
        //List<String> roles
    ){
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.role = role;
        //this.roles = roles;

    }
}
