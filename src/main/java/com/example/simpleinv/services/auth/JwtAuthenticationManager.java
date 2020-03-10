//package com.example.simpleinv.services.auth;
//
//import com.example.simpleinv.model.User;
//import com.example.simpleinv.repositories.Admin.UserRepositories;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtAuthenticationManager implements AuthenticationManager {
//
//  @Autowired
//  PasswordEncoder passwordEncoder;
//
//  @Autowired
//  UserRepositories userRepo;
//
//  boolean flag = false;
//
//  public boolean isFlag() {
//    return flag;
//  }
//
//  public void setFlag(boolean flag) {
//    this.flag = flag;
//  }
//
//  @Override
//  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//    //LOGIC DISINI!!!
//
//    setFlag(false);
//    System.out.println("MASUK authenticate Authentication Manager");
//    System.out.println(authentication.getPrincipal());
//    System.out.println(authentication.getCredentials());
//    System.out.println(authentication.getDetails());
//    System.out.println(authentication.isAuthenticated());
//
//    Optional<User> user = userRepo.findUserByUsername((String)authentication.getPrincipal());
//    User users = user.orElseThrow(() -> new IllegalArgumentException("Invalid Username or Password"));
//
//    System.out.println(authentication.getCredentials());
//    System.out.println(users.getPassword());
//    String passwordLogin = (String)authentication.getCredentials();
//    String passwordUserEntity = users.getPassword();
//    if(passwordEncoder.matches(passwordLogin,passwordUserEntity)){
//      System.out.println("Password VALID");
//      setFlag(true);
//      System.out.println(isFlag());
//    }
//    return null;
//  }
//  public boolean flag(){
//    System.out.println(isFlag());
//    return isFlag();
//  }
//}
