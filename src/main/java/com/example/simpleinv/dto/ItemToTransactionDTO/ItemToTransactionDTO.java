package com.example.simpleinv.dto.ItemToTransactionDTO;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ItemToTransactionDTO {
  List<ItemDetailsDTO> itemDetailsDTOS;
  private Integer userId;
  private Integer GrandTotal;
}
