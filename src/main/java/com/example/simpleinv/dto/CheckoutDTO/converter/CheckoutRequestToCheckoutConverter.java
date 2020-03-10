package com.example.simpleinv.dto.CheckoutDTO.converter;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutRequestDTO;
import com.example.simpleinv.model.Checkout;

public class CheckoutRequestToCheckoutConverter {

    public final static Checkout convertCreate(Checkout request){
        Checkout checkout = new Checkout();
        //checkout.setCheckoutId(request.getCheckoutId());
        checkout.setCheckoutItemId(request.getCheckoutItemId());
        //checkout.setCheckoutItemName(request.getCheckoutItemName());
        //checkout.setCheckoutItemType(request.getCheckoutItemType());
        checkout.setCheckoutItemQty(request.getCheckoutItemQty());
        //checkout.setCheckoutItemPrice(request.getCheckoutItemPrice());
        checkout.setCheckoutTotal(request.getCheckoutTotal());
        //checkout.setCheckoutCartId(requestL.getCheckoutCartId());
        checkout.setCheckoutCustId(request.getCheckoutCustId());
        //checkout.setCheckItemDeleted(request.isCheckItemDeleted());
        //checkout.setItemId(request.getItemId());
        return checkout;
    }

    public final static Checkout convertUpdate(CheckoutRequestDTO request){
        Checkout checkout = new Checkout();
        //checkout.setCheckoutId(request.getCheckoutId());
        checkout.setCheckoutItemId(request.getCheckoutItemId());
        //checkout.setCheckoutItemName(request.getCheckoutItemName());
        //checkout.setCheckoutItemType(request.getCheckoutItemType());
        checkout.setCheckoutItemQty(request.getCheckoutItemQty());
        //checkout.setCheckoutItemPrice(request.getCheckoutItemPrice());
        checkout.setCheckoutTotal(request.getCheckoutTotal());
        //checkout.setCheckoutCartId(request.getCheckoutCartId());
        checkout.setCheckoutCustId(request.getCheckoutCustId());
        //checkout.setItemId(request.getItemId());
        return checkout;
    }
}
