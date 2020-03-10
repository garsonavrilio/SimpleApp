//package com.example.simpleinv.config;
//
//import com.auth0.jwt.impl.ClaimsHolder;
//import com.auth0.jwt.interfaces.Claim;
//import com.example.simpleinv.dto.UserDTO.UserResponseDTO;
//import com.example.simpleinv.model.User;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//
//  private static final long serialVersionUID = 1977293640205784697L;
//  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//
//  @Value("${jwt.secret}")
//  private String secret;
//
//  //ngambil username dari jwtToken
//  public String getUsernameFromToken(String token){
//    System.out.println("MASUK getUsernameFromToken");
//    return getClaimFromToken(token, Claims::getSubject);
//  }
//  public String getPayloadFromToken( String token , String key ) {
//    Claims claim = getAllClaimsFromToken(token);
//    System.out.println("CLAIM");
//    System.out.println(claim);
//    return (String)claim.get(key);
//  }
//
//  //ngambil expirationDate dari jwtToken
//  public Date getExpirationDateFromToken(String token){
//    return getClaimFromToken(token, Claims::getExpiration);
//  }
//
//  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
//    System.out.println("MASUK getClaimsFromToken");
//    final Claims claims = getAllClaimsFromToken(token);
//    System.out.println("Dapet claims nya : " +claims);
//    return claimsResolver.apply(claims);
//  }
//
//  //untuk ngambil semua informasi dari token yang dibutuhkan dari secret key
//  private Claims getAllClaimsFromToken(String token){
//    System.out.println("MASUK getAllClaimsFromToken");
//    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//  }
//
//  //cek kalo token nya masi belom expired
//  private Boolean isTokenExpired(String token){
//    final Date expiration = getExpirationDateFromToken(token);
//    return expiration.before(new Date());
//  }
//
//  //generate token
//  public String generateToken(User user){
//    Map<String, Object> claims = new HashMap<>();
//    claims.put("fullname",user.getFullname());
//    return doGenerateToken(claims, user.getUsername());
//  }
//
//  //Ketika membuat token :
//  // 1. tentukan claim token seperti issuer,expiration,subject dan id
//  // 2. Sign jwt menggunakan HS512 algorithm dan secret Key
//  // 3. According to JWS compact serialization.
//  private String doGenerateToken(Map<String,Object> claims, String subject){
//    return Jwts.builder()
//        .setClaims(claims)
//        .setSubject(subject)
//        .setIssuedAt(new Date(System.currentTimeMillis()))
//        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//        .signWith(SignatureAlgorithm.HS512, secret).compact();
//  }
//
//  //validate token
//  public Boolean validateToken(String token, User userDetails){
//    final String username = getUsernameFromToken(token);
//    return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
//  }
//
//
//
//
//}
