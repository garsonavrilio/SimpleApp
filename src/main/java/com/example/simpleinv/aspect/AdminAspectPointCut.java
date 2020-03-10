package com.example.simpleinv.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AdminAspectPointCut {

  @Before("getNamePointCut()")
  public void loggingAdvice(){
    System.out.println("logging advice");
  }

  @Pointcut("execution(public List<UserResponseDTO> getAllUser())")
  public void getNamePointCut(){}
}
