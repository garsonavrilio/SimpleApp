package com.example.simpleinv.services.checkout.impl;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.dto.CheckoutDTO.converter.CheckoutToResponseConverter;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.repositories.Checkout.CheckoutRepositories;
import com.example.simpleinv.services.checkout.CheckoutService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CheckoutServiceImplement implements CheckoutService {

    @Autowired
    CheckoutRepositories checkoutRepositories;

    @Override
    public List<CheckoutResponseDTO> getAllCheckout() {
        return StreamSupport.stream(checkoutRepositories.findAll().spliterator(),false)
                .map(CheckoutToResponseConverter::convert).collect(Collectors.toList());
    }

    @Override
    public CheckoutResponseDTO deleteCheckout(Integer id) {
        Optional<Checkout> checkout = checkoutRepositories.findById(id);
        checkoutRepositories.deleteById(id);
        return CheckoutToResponseConverter.convert(checkout.get());
    }

    @Override
    public List<CheckoutResponseDTO> getCheckoutById(Integer Id) {
        return checkoutRepositories.getAllCheckoutById(Id).stream()
                .map(CheckoutToResponseConverter::convert).collect(Collectors.toList());
    }
}
