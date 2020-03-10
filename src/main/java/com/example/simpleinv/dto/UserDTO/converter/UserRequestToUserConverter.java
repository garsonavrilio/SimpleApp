package com.example.simpleinv.dto.UserDTO.converter;

import com.example.simpleinv.dto.UserDTO.UserRequestDTO;
import com.example.simpleinv.model.User;

public class UserRequestToUserConverter {
    public final static User convertCreate(UserRequestDTO request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        user.setFullname(request.getFullname());
        user.setGender(request.getGender());
        user.setRole(request.getRole());
        //user.setUser_roles(request.getUser_roles());
        return user;
    }

    public final static User convertUpdate(UserRequestDTO request){
        User user = new User();
        user.setUserId(request.getUserId());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFullname(request.getFullname());
        user.setGender(request.getGender());
        user.setRole(request.getRole());
        //user.setUser_roles(request.getUser_roles());
        return user;
    }
}
