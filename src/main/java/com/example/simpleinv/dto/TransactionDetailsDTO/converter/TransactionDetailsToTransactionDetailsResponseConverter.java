package com.example.simpleinv.dto.TransactionDetailsDTO.converter;

import com.example.simpleinv.dto.TransactionDetailsDTO.TransactionDetailsResponseDTO;
import com.example.simpleinv.model.TransactionDetails;

public class TransactionDetailsToTransactionDetailsResponseConverter {
  public static TransactionDetailsResponseDTO convert (TransactionDetails model){
    return new TransactionDetailsResponseDTO(model.getId(),model.getTransactionId(),model.getItemId(),model.getItemQty(),model.getSubTotal(),model.getGrandTotal(),model.getDate());
  }
}
