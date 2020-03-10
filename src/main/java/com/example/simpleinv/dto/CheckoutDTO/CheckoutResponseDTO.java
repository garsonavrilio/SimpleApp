package com.example.simpleinv.dto.CheckoutDTO;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Check;

@Data
@ToString(callSuper = true)
public class CheckoutResponseDTO {

    public CheckoutResponseDTO(Integer checkoutId, Integer checkoutItemId, Integer checkoutItemQty, Integer checkoutTotal , Integer checkoutCustId){
        super();
        this.checkoutId = checkoutId;
        this.checkoutItemId = checkoutItemId;
        //this.checkoutItemName = checkoutItemName;
        //this.checkoutItemType = checkoutItemType;
        this.checkoutItemQty = checkoutItemQty;
        //this.checkoutItemPrice = checkoutItemPrice;
        this.checkoutTotal = checkoutTotal;
        //this.checkoutCartId = checkoutCartId;
        this.checkoutCustId = checkoutCustId;
        //this.checkItemDeleted = checkItemDeleted;
        //this.itemId = itemId;

    }
    private Integer checkoutId;
    private Integer checkoutItemId;
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
