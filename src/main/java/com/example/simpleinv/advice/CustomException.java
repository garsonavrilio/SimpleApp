package com.example.simpleinv.advice;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomException {
  private String message;
  private HttpStatus status;
  private Integer statusCode ;

  CustomException( String message, HttpStatus status ) {
    this.message = message;
    this.status = status;
    this.statusCode = status.value();
  }
}