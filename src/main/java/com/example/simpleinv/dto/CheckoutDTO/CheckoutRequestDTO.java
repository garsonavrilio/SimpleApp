package com.example.simpleinv.dto.CheckoutDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class CheckoutRequestDTO {
    private Integer checkoutId;
    private  Integer checkoutItemId;
    //private String checkoutItemName;
    //private String checkoutItemType;
    private Integer checkoutItemQty;
    //private Integer checkoutItemPrice;
    private Integer checkoutTotal;
    //private Integer checkoutCartId;
    private Integer checkoutCustId;
    //private boolean checkItemDeleted;
    //private Integer itemId;
}
