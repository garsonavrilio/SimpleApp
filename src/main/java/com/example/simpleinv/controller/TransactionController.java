package com.example.simpleinv.controller;

import com.example.simpleinv.dto.CheckoutToTransactionDTO.CheckoutToTransactionRequestDTO;
import com.example.simpleinv.dto.ItemToTransactionDTO.ItemToTransactionDTO;
import com.example.simpleinv.model.Transaction;
import com.example.simpleinv.model.TransactionDetails;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.token.TokenService;
import com.example.simpleinv.services.transaction.TransactionService;
import com.example.simpleinv.services.transactiondetails.TransactionDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

  @Autowired
  TokenService tokenService;

  @Autowired
  TransactionService transactionService;

  @Autowired
  PermissionService permissionService;

  @Autowired
  TransactionDetailsService transactionDetailsService;

//    @RequestMapping(value = "/transaction", method = RequestMethod.POST, produces = "application/json")
//    public Transaction createTransaction(@RequestHeader(value = "Authorization") String token,@RequestBody Integer request)
//        throws JsonProcessingException {
//        String url = "/transaction";
//        boolean flag = tokenService.tokenController(token,url);
//        if (flag) return transactionService.createTransaction(request);
//        else throw new BadCredentialsException("You Do Not have Permission to continue this process");
//    }

  @RequestMapping(value = "/transaction/all", method = RequestMethod.GET,
      produces = "application/json")
  public List<Transaction> getAllTransaction(@RequestHeader(value = "Authorization") String token)
      throws JsonProcessingException {
    String url = "/transaction/all";
    boolean flag = tokenService.tokenController(token, url);
      if (flag) {
          return transactionService.getAllTransaction();
      } else {
          throw new IllegalArgumentException("You Do Not have Permission to continue this process");
      }
  }


  @RequestMapping(value = "/transaction/history", method = RequestMethod.GET,
      produces = "application/json")
  public List<Transaction> getAllTransactionByDate(
      @RequestHeader(value = "Authorization") String token, @RequestParam("startDate") Long date1,
      @RequestParam("endDate") Long date2) throws JsonProcessingException {
    String url = "/transaction/history";
    boolean flag = tokenService.tokenController(token, url);
      if (flag) {
          return transactionService
              .getAllTransactionByDate(new Date(date1 * 1000), new Date(date2 * 1000));
      } else {
          throw new BadCredentialsException("You Do Not have Permission to continue this process");
      }
  }

  @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET,
      produces = "application/json")
  public Transaction getTransactionById(@RequestHeader(value = "Authorization") String token,
      @PathVariable Integer id) throws JsonProcessingException {
    String url = "/transaction/{id}";
    boolean flag = tokenService.tokenController(token, url);
      if (flag) {
          return transactionService.findTransactionById(id);
      } else {
          throw new BadCredentialsException("You Do Not have Permission to continue this process");
      }
  }

  @RequestMapping(value = "/transaction/details/{id}", method = RequestMethod.GET,
      produces = "application/json")
  public List<TransactionDetails> getTransactionDetails(
      @RequestHeader(name = "Authorization") String token, @PathVariable Integer id)
      throws JsonProcessingException {
    String url = "/transaction/details/{id}";
    boolean flag = tokenService.tokenController(token, url);
      if (flag) {
          return transactionDetailsService.getTransactionDetails(id);
      } else {
          throw new BadCredentialsException("You Do Not have Permission to continue this process");
      }
  }

  @RequestMapping(value = "/transaction/create", method = RequestMethod.POST,
      produces = "application/json")
  public Transaction createTransactionAndTransactionDetails(
      @RequestHeader(name = "Authorization") String token,
      @RequestBody ItemToTransactionDTO request) throws JsonProcessingException {
    String url = "/transaction/create";
    boolean flag = tokenService.tokenController(token, url);
      if (flag) {
          return transactionService.createTransactionAndTransactionDetails(request);
      } else
          throw new BadCredentialsException("You Do Not have Permission to continue this process");
  }

}
