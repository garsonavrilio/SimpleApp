package com.example.simpleinv.dto.CustomerDTO.converter;

import com.example.simpleinv.dto.CustomerDTO.CustomerResponseDTO;
import com.example.simpleinv.model.Customer;

public class CustomerToResponseConverter {
    public final static CustomerResponseDTO convert (Customer customer){
        return new CustomerResponseDTO(customer.getCustId(), customer.getCustName(), customer.getCustAddress());
    }
}
