package com.example.simpleinv.dto.TransactionDTO;

import com.example.simpleinv.model.Transaction;

import java.util.List;

public class TransactionDTO {
    public final static Transaction createTransaction(Transaction transaction){
        Transaction t = new Transaction();
        //t.setCheckoutId(transaction.getCheckoutId());
        t.setTransactionId(transaction.getTransactionId());
        t.setCustId(transaction.getCustId());
        //t.setCustName(transaction.getCustName());
        //t.setCustAddress(transaction.getCustAddress());
        t.setTotalAmount(transaction.getTotalAmount());
        t.setDateTime(transaction.getDateTime());
        return t;
    }

}
