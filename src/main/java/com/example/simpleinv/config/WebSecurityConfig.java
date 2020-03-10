//package com.example.simpleinv.config;
//
//import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
//import com.example.simpleinv.services.auth.JwtAuthenticationManager;
//import com.example.simpleinv.services.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//  @Autowired
//  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//  @Autowired
//  private UserService userService;
//
//  @Autowired
//  private JwtRequestFilter jwtRequestFilter;
//
//  //@Autowired
//  //public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
//  //  auth.userDetailsService(UserResponseDTO).passwordEncoder(passwordEncoder());
//  //}
//
////  @Autowired
////  public void configureGlobal(AuthenticationManagerBuilder authenticationMgr)
////      throws Exception {
////    authenticationMgr.inMemoryAuthentication()
////        .withUser("jduser").password("jdu@123").authorities("ROLE_USER")
////        .and()
////        .withUser("jdadmin").password("jda@123").authorities("ROLE_USER","ROLE_ADMIN");
////  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder(){
//    return new BCryptPasswordEncoder();
//  }
//
//  @Override
//  protected void configure(HttpSecurity httpSecurity)throws Exception{
//    System.out.println("configure");
//    httpSecurity.csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/authenticate","/user/sign-up")
//        //.access("hasRole('ROLE_ADMIN')")
//        .permitAll()
//
//        .anyRequest()
//        .authenticated()
//        .and()
//
//        .exceptionHandling()
//        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//        .and()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    System.out.println("configure2");
//
//    System.out.println("kena filter");
//    httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    System.out.println("kena filter2");
//  }
//}
