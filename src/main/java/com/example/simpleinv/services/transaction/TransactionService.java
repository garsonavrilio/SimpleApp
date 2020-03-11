package com.example.simpleinv.services.transaction;

import com.example.simpleinv.dto.CheckoutToTransactionDTO.CheckoutToTransactionRequestDTO;
import com.example.simpleinv.dto.ItemToTransactionDTO.ItemToTransactionDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Transaction;

import com.example.simpleinv.model.TransactionDetails;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    //Transaction createTransaction(Integer request);
    List<Transaction> getAllTransaction();
    List<Transaction> getAllTransactionByDate(Date date1, Date date2);
    Transaction findTransactionById(Integer id);
    Transaction createTransactionAndTransactionDetails(ItemToTransactionDTO request);
}
