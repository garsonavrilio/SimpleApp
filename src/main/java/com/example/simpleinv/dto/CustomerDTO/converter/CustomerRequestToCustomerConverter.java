package com.example.simpleinv.dto.CustomerDTO.converter;

import com.example.simpleinv.dto.CustomerDTO.CustomerRequestDTO;
import com.example.simpleinv.model.Customer;

public class CustomerRequestToCustomerConverter {
    public final static Customer convertCreate(CustomerRequestDTO request){
        Customer customer = new Customer();
        customer.setCustName(request.getCustName());
        customer.setCustAddress(request.getCustAddress());
        return customer;
    }

    public final static Customer convertUpdate(CustomerRequestDTO request){
        Customer customer = new Customer();
        customer.setCustId(request.getCustId());
        customer.setCustName(request.getCustName());
        customer.setCustAddress(request.getCustAddress());
        return customer;
    }
}
