package com.example.simpleinv.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactionDetails_table")
public class TransactionDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer transactionId;
  private Integer itemId;
  private Integer itemQty;
  private Integer subTotal;
  private Integer grandTotal;
  private Date date;
}
