package com.example.simpleinv.dto.ItemToTransactionDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ItemDetailsDTO {
  private Integer itemId;
  private Integer itemQty;
  private Integer subTotal;
}
