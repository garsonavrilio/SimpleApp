package com.example.simpleinv.advice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

  private static final long serialVersionUID = 7411338641833345168L;
  private Integer codeStatus;
  private String code;
}
