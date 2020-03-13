package com.example.simpleinv.advice;

import javax.xml.ws.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SimpleInvControllerAdvice {

  @ExceptionHandler(value = BadCredentialsException.class)
  public ResponseEntity<CustomException> badCredentialError(BadCredentialsException exception) {
    HttpStatus status = HttpStatus.UNAUTHORIZED;
    return new ResponseEntity<CustomException>(
        new CustomException(exception.getLocalizedMessage(), status), status);
  }

  @ExceptionHandler(value = IllegalArgumentException.class)
  public ResponseEntity<CustomException> illegalArgumentException(
      IllegalArgumentException exception) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    return new ResponseEntity<CustomException>(
        new CustomException(exception.getLocalizedMessage(), status),status);
  }

//    @ExceptionHandler(value = Exception.class)
//  public ResponseEntity<ErrorResponse> errorHandler(Exception e){
//      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
//      return new ResponseEntity<ErrorResponse>(new ErrorResponse(status,e.getMessage()))
//    }

}

