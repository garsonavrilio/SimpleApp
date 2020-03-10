//package com.example.simpleinv.config;
//
//import java.io.IOException;
//import java.io.Serializable;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//  //private static final long serialVersionUID = 8601601511772238852L;
//  // kelas ini dibuat cuma  untuk kalau authentication failed unauthorizer error http 401
//  @Override
//  public void commence(HttpServletRequest request, HttpServletResponse response,
//      AuthenticationException authException) throws IOException, ServletException {
//      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//  }
//}
