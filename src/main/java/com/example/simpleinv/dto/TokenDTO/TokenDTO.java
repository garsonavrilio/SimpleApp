package com.example.simpleinv.dto.TokenDTO;

import java.util.Date;
import lombok.Data;
import org.hibernate.exception.DataException;

@Data
public class TokenDTO {
  private Integer id;
  private Date createdAt;
  private Date expiredAt;
}
