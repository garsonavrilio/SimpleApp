package com.example.simpleinv.dto.ItemDTO;

import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@ToString(callSuper = true)
public class ItemRequestDTO {
    private Integer itemId;
    private String itemName;
    private String itemType;
    private Integer itemPrice;
    private Integer itemSellPrice;
    private Integer itemQty;
    private boolean isDeleted;
}
