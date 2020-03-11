package com.example.simpleinv.dto.UserDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UpdateUserDTO {
  private Integer userId;
  private String username;
  private String password;
  private String fullname;
  private String gender;
}
