package com.example.simpleinv.services.checkout;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.model.Checkout;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {
    List<CheckoutResponseDTO> getAllCheckout();
    CheckoutResponseDTO deleteCheckout(Integer id);
    List<CheckoutResponseDTO> getCheckoutById(Integer Id);
}
