package com.example.simpleinv.aspect;

import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class AdminAspect {
  @Before("execution(List<UserResponseDTO> getAllUser())")
  public void getAdvice(){
    System.out.println("Advice dluan brok yang jalan");
  }
}
