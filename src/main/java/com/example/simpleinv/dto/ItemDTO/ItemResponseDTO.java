package com.example.simpleinv.dto.ItemDTO;

import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@ToString(callSuper = true)
public class ItemResponseDTO {
    public ItemResponseDTO(Integer itemId, String itemName, String itemType,Integer itemPrice, Integer itemSellPrice, Integer itemQty, boolean isDeleted){
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.itemSellPrice = itemSellPrice;
        this.itemQty = itemQty;
        this.isDeleted = isDeleted;

    }
    private Integer itemId;
    private String itemName;
    private String itemType;
    private Integer itemPrice;
    private Integer itemSellPrice;
    private Integer itemQty;
    private boolean isDeleted;
}
