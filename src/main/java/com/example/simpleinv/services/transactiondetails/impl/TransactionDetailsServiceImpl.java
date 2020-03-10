package com.example.simpleinv.services.transactiondetails.impl;

import com.example.simpleinv.model.TransactionDetails;
import com.example.simpleinv.repositories.Checkout.CheckoutRepositories;
import com.example.simpleinv.repositories.TransactionDetails.TransactionDetailsRepositories;
import com.example.simpleinv.services.transaction.TransactionService;
import com.example.simpleinv.services.transactiondetails.TransactionDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

  @Autowired
  TransactionDetailsRepositories transactionDetailsRepositories;

  @Autowired
  TransactionService transactionService;

  @Autowired
  CheckoutRepositories checkoutRepositories;


  @Override
  public List<TransactionDetails> getTransactionDetails(Integer id) {
    return transactionDetailsRepositories.getTransactionDetailsByTransactionId(id);
  }
}
