package com.example.simpleinv.services.token;

import com.example.simpleinv.dto.TokenDTO.TokenDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

  boolean tokenValid(String token) throws JsonProcessingException;

  TokenDTO getDetailsByToken(String token) throws JsonProcessingException;

  boolean tokenController(String token, String url) throws JsonProcessingException;
}