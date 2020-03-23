package com.example.simpleinv.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//      registry.addMapping("/**");
//    }
//
////    @Bean
////    public FilterRegistrationBean<CorsFilter> corsFilter() {
////      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////      CorsConfiguration config = new CorsConfiguration();
////      config.setAllowCredentials(true);
////      config.addAllowedOrigin("http://localhost:3000");
////      config.addAllowedHeader("*");
////      config.addAllowedMethod("*");
////      source.registerCorsConfiguration("/**", config);
////      FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
////      bean.setOrder(0);
////      return bean;
////    }
//
//
//}
