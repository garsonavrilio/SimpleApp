package com.example.simpleinv.advice;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ErrorResponse implements Serializable {

  private static final long serialVersionUID = 6054690413402287854L;
  private Integer codeStatus;
  private String code;
  private String message;

}
