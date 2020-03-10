package com.example.simpleinv.dto.itemToCheckoutDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ItemToCheckoutRequestDTO {
    private Integer itemToCheckoutItemId;
    private Integer itemToCheckoutUserId;
    private Integer itemToCheckoutItemQty;
}
