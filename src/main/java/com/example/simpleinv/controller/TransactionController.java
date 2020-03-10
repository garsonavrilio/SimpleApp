package com.example.simpleinv.controller;

import com.example.simpleinv.dto.CheckoutToTransactionDTO.CheckoutToTransactionRequestDTO;
import com.example.simpleinv.model.Transaction;
import com.example.simpleinv.model.TransactionDetails;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.transaction.TransactionService;
import com.example.simpleinv.services.transactiondetails.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    TransactionDetailsService transactionDetailsService;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST, produces = "application/json")
    public Transaction createTransaction(@RequestHeader(value = "Authorization") String token,@RequestBody Integer request){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/transaction");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return transactionService.createTransaction(request);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }
    @RequestMapping(value = "/transaction/all", method = RequestMethod.GET, produces = "application/json")
    public List<Transaction> getAllTransaction(@RequestHeader(value = "Authorization") String token){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/transaction/all");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return transactionService.getAllTransaction();
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }


    @RequestMapping(value = "/transaction/history",method = RequestMethod.GET,produces = "application/json")
    public List<Transaction> getAllTransactionByDate(@RequestHeader(value = "Authorization") String token,@RequestParam("startDate") Long date1, @RequestParam("endDate") Long date2){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/transaction/history");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return transactionService.getAllTransactionByDate(new Date(date1*1000), new Date(date2*1000));
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET, produces = "application/json")
    public Transaction getTransactionById(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/transaction/{id}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return transactionService.findTransactionById(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/transaction/details/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<TransactionDetails> getTransactionDetails (@PathVariable Integer id){
        return transactionDetailsService.getTransactionDetails(id);
    }


}
