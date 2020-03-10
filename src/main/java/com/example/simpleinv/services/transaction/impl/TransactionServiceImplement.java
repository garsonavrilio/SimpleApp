package com.example.simpleinv.services.transaction.impl;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.dto.CheckoutDTO.converter.CheckoutToResponseConverter;
import com.example.simpleinv.dto.CheckoutToTransactionDTO.CheckoutToTransactionRequestDTO;
import com.example.simpleinv.dto.TransactionDTO.TransactionDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Customer;
import com.example.simpleinv.model.Transaction;
import com.example.simpleinv.model.TransactionDetails;
import com.example.simpleinv.model.User;
import com.example.simpleinv.repositories.Admin.UserRepositories;
import com.example.simpleinv.repositories.Checkout.CheckoutRepositories;
import com.example.simpleinv.repositories.Customer.CustomerRepositories;
import com.example.simpleinv.repositories.Transaction.TransactionRespoitories;
import com.example.simpleinv.repositories.TransactionDetails.TransactionDetailsRepositories;
import com.example.simpleinv.services.transaction.TransactionService;
import java.util.Calendar;
import java.util.stream.Stream;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TransactionServiceImplement implements TransactionService {

  @Autowired
  TransactionRespoitories transactionRepo;

  @Autowired
  UserRepositories userRepositories;

  @Autowired
  CheckoutRepositories checkoutRepo;

  @Autowired
  TransactionDetailsRepositories transactionDetailsRepositories;


  @Transactional
  @Override
  public Transaction createTransaction(Integer request) {
    Optional<User> users = userRepositories.findById(request);
    //List<CheckoutResponseDTO> checkout = StreamSupport.stream(checkoutRepo.findAll().spliterator(),false)
    //    .map(CheckoutToResponseConverter::convert).collect(Collectors.toList());
    User user = users.orElseThrow(()->new IllegalArgumentException("No User Found"));
    List<Checkout> checkout = checkoutRepo.findCheckoutbyCustId(request);
    //if (!user.isPresent()) {
    //  throw new IllegalArgumentException();
   // }
    //Customer cutomer1 =  customer.get();
    Transaction transaction = new Transaction();
    transaction.setTotalAmount(checkoutRepo.grandTotalCheckout(request));
    transaction.setCustId(request);
    transaction.setDateTime(new Date());
    if(transaction.getTotalAmount()==null) {
      throw new IllegalArgumentException("Checkout Empty");
    }
    TransactionDTO.createTransaction(transactionRepo.save(transaction));


    for(Checkout checkouts : checkout){
      TransactionDetails transactionDetails = new TransactionDetails();
      transactionDetails.setTransactionId(transaction.getTransactionId());
      transactionDetails.setItemId(checkouts.getCheckoutItemId());
      transactionDetails.setItemQty(checkouts.getCheckoutItemQty());
      transactionDetails.setSubTotal(checkouts.getCheckoutTotal());
      transactionDetails.setGrandTotal(transaction.getTotalAmount());
      transactionDetails.setDate(new Date());
      transactionDetailsRepositories.save(transactionDetails);
    }
    //transaction.setCustAddress(cutomer1.getCustAddress());
    //transaction.setCustName(cutomer1.getCustName());
    //transaction.setCheckoutId();
    System.out.println("asassas");
    checkoutRepo.deleteCheckoutById(request);
    System.out.println("babababab");
    return transaction;
  }

  @Override
  public List<Transaction> getAllTransaction() {
    return StreamSupport.stream(transactionRepo.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public List<Transaction> getAllTransactionByDate(Date date1, Date date2) {
    System.out.println(date1);
    System.out.println(date2);
    Calendar cal = Calendar.getInstance();
    cal.setTime(date1);
    cal.set(Calendar.HOUR_OF_DAY,0);
    cal.set(Calendar.MINUTE,0);
    cal.set(Calendar.SECOND,0);
    cal.set(Calendar.MILLISECOND,0);

    Calendar cal1 = Calendar.getInstance();
    cal1.setTime(date2);
    cal1.set(Calendar.HOUR_OF_DAY,23);
    cal1.set(Calendar.MINUTE,59);
    cal1.set(Calendar.SECOND,59);
    cal1.set(Calendar.MILLISECOND,999);

    System.out.println(cal.getTime());
    System.out.println(cal1.getTime());
    return transactionRepo.getTransactionByDate(cal.getTime(), cal1.getTime());
  }

  @Override
  public Transaction findTransactionById(Integer id) {
    Optional<Transaction> transaction = transactionRepo.findById(id);
    return transaction.get();
  }
}