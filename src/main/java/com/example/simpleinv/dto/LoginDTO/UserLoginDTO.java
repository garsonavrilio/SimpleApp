package com.example.simpleinv.dto.LoginDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UserLoginDTO {
  private String username;
  private String password;
}
