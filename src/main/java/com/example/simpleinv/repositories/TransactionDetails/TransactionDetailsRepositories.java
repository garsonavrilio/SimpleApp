package com.example.simpleinv.repositories.TransactionDetails;

import com.example.simpleinv.model.TransactionDetails;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TransactionDetailsRepositories extends CrudRepository<TransactionDetails,Integer> {

  @Query("SELECT t FROM TransactionDetails t WHERE t.transactionId = ?1")
  List<TransactionDetails> getTransactionDetailsByTransactionId(Integer id);

}
