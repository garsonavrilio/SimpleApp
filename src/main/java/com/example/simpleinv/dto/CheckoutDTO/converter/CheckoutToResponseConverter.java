package com.example.simpleinv.dto.CheckoutDTO.converter;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.model.Checkout;

import java.util.List;

public class CheckoutToResponseConverter {
    public final static CheckoutResponseDTO convert (Checkout checkout){
        return new CheckoutResponseDTO(checkout.getCheckoutId(),checkout.getCheckoutItemId(),checkout.getCheckoutItemQty()
                , checkout.getCheckoutTotal(), checkout.getCheckoutCustId());
    }
}
