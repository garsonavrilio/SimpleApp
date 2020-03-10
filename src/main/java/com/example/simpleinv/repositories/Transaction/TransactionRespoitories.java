package com.example.simpleinv.repositories.Transaction;

import com.example.simpleinv.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TransactionRespoitories extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t from Transaction t WHERE t.dateTime >= ?1")
    List<Transaction> getTransactionByDateTime(Date date);

    @Query("SELECT t from Transaction t WHERE t.dateTime >= ?1 AND t.dateTime <= ?2")
    List<Transaction> getTransactionByDate(Date date1, Date date2);

    //@Query("SELECT FROM Transaction t")
    //List<Transaction> getTransactionDetail(Integer custId);

    //@Query("SELECT SUM(c.checkoutTotal) FROM Checkout c WHERE c.checkoutCustId = ?1")
    //Integer getGrandTotal(Integer id);
}
