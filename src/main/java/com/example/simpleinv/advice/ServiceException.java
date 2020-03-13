package com.example.simpleinv.advice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends BaseException {

  private static final long serialVersionUID = -8279732557037457868L;

  private HttpStatus status;

}
