package com.example.simpleinv.services.customer;

import com.example.simpleinv.dto.CustomerDTO.CustomerRequestDTO;
import com.example.simpleinv.dto.CustomerDTO.CustomerResponseDTO;
import com.example.simpleinv.model.Customer;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    List<CustomerResponseDTO> getAllCustomer();
    //Customer findCustomerName(String name);
    CustomerResponseDTO getCustomerId(Integer id);
    CustomerResponseDTO createCustomer(CustomerRequestDTO request);
    CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO request);
    CustomerResponseDTO deleteCustomer(Integer id);
    //CustomerResponseDTO getCustomerDetailByName(String name);
    //Customer findCustomerDetail(Integer id);
}
