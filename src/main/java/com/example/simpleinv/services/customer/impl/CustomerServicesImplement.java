package com.example.simpleinv.services.customer.impl;

import com.example.simpleinv.dto.CustomerDTO.CustomerRequestDTO;
import com.example.simpleinv.dto.CustomerDTO.CustomerResponseDTO;
import com.example.simpleinv.dto.CustomerDTO.converter.CustomerRequestToCustomerConverter;
import com.example.simpleinv.dto.CustomerDTO.converter.CustomerToResponseConverter;
import com.example.simpleinv.model.Customer;
import com.example.simpleinv.repositories.Customer.CustomerRepositories;
import com.example.simpleinv.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServicesImplement implements CustomerService {
    @Autowired
    CustomerRepositories customerRepositories;


    @Override
    public List<CustomerResponseDTO> getAllCustomer() {
        return StreamSupport.stream(customerRepositories.findAll().spliterator(),false)
                .map(i-> CustomerToResponseConverter.convert(i)).collect(Collectors.toList());
    }

    /*@Override
    public Customer findCustomerName(String name) {
        List<Customer> temp = customerRepositories.findByName(name);
        return CustomerToResponseConverter.convert(temp);
    }*/

    @Override
    public CustomerResponseDTO getCustomerId(Integer id) {
        Optional<Customer> temp = customerRepositories.findById(id);
        return CustomerToResponseConverter.convert(temp.get());
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO request) {
        Customer temp = CustomerRequestToCustomerConverter.convertCreate(request);
        return CustomerToResponseConverter.convert(customerRepositories.save(temp));
    }

    @Override
    public CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO request) {
        boolean flag = customerRepositories.existsById(id);
        if(flag==true){
            Customer temp = CustomerRequestToCustomerConverter.convertUpdate(request);
            temp.setCustId(id);
            return CustomerToResponseConverter.convert(customerRepositories.save(temp));
        }
        else throw new IllegalArgumentException();
    }

    @Override
    public CustomerResponseDTO deleteCustomer(Integer id) {
        Optional<Customer> temp = customerRepositories.findById(id);
        customerRepositories.deleteById(id);
        return CustomerToResponseConverter.convert(temp.get());
    }

    /*@Override
    public Customer findCustomerDetail(Integer id) {
        return customerRepositories.findDetailId(id);
    }*/


}
