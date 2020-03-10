package com.example.simpleinv.dto.UserRoleDTO;

import com.example.simpleinv.model.User;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UserRoleResponseDTO {

  public UserRoleResponseDTO(String userName,String roleName){

    this.userName = userName;
    this.roleName = roleName;
  }

  private String userName;
  private String roleName;
}
