//package com.example.simpleinv.config;
//
//import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
//import com.example.simpleinv.model.User;
//import com.example.simpleinv.repositories.Admin.UserRepositories;
//import com.example.simpleinv.repositories.User_Role.UserRole_Repositories;
//import com.example.simpleinv.services.user.UserService;
//import io.jsonwebtoken.ExpiredJwtException;
//import java.io.IOException;
//import java.util.Collections;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.jackson2.SimpleGrantedAuthorityMixin;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//  @Autowired
//  JwtTokenUtil jwtTokenUtil;
//
//  @Autowired
//  UserRole_Repositories userRole_repo;
//
//  @Autowired
//  UserService userService;
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//      FilterChain filterChain) throws ServletException, IOException {
//
//    System.out.println("MASUK doFilterInternal");
//
//    final String requestTokenHeader = request.getHeader("Authorization");
//    System.out.println(requestTokenHeader);
//
//    String username = null;
//    String jwtToken = null;
//    if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//      jwtToken = requestTokenHeader.substring(7);
//      System.out.println("Token : "+jwtToken);
//      try {
//        System.out.println("MASUK REQUEST FILTER");
//        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//        System.out.println("Username : " + username);
//      } catch (IllegalArgumentException e) {
//        System.out.println("UNABLE TO GET JWT TOKEN");
//      } catch (ExpiredJwtException e) {
//        System.out.println("THE TOKEN HAS EXPIRED");
//      }
//    } else {
//      logger.warn("JWT TOKEN IS NOT START WITH BEARER");
//    }
//
//    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//      User userDetails = userService.getUserByUsername(username);
//
//      System.out.println("Ngambil UserDetails by Username");
//      System.out.println(userDetails);
//      if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//        System.out.println("VALIDATING TOKEN");
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//            userDetails, null, Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));// HARUSNYA NTAR DISINI BUAT USER.GETROLE() supaya bisa permit ke endpoint lainnya
//        //Collection.Singleton Remove All digunakan untuk menghapus element yg diinginkan untuk di hapus di sebuah list
//        System.out.println(usernamePasswordAuthenticationToken);
//
//        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));//ngasih sessionID sama requestAddress
//        System.out.println(usernamePasswordAuthenticationToken);
//
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//      }
//    }
//    System.out.println("filterChain");
//    filterChain.doFilter(request,response);
//    System.out.println("filterChain2");
//  }
//}

