package com.example.simpleinv.services.transactiondetails;

import com.example.simpleinv.model.TransactionDetails;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface TransactionDetailsService {
  List<TransactionDetails> getTransactionDetails(Integer id);
}
