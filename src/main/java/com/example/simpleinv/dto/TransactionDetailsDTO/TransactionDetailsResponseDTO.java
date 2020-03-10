package com.example.simpleinv.dto.TransactionDetailsDTO;

import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TransactionDetailsResponseDTO {
  public TransactionDetailsResponseDTO(Integer id,Integer transactionId, Integer itemId, Integer itemQty,Integer subTotal,Integer grandTotal, Date date){
    this.id = id;
    this.transactionId = transactionId;
    this.itemId = itemId;
    this.itemQty = itemQty;
    this.subTotal = subTotal;
    this.grandTotal = grandTotal;
    this.date = date;
  }
  private Integer id;
  private Integer transactionId;
  private Integer itemId;
  private Integer itemQty;
  private Integer subTotal;
  private Integer grandTotal;
  private Date date;
}
