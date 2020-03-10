package com.example.simpleinv.dto.JwtDTO;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JwtResponseDTO {
  String token;

}
