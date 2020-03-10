package com.example.simpleinv.controller;

import com.example.simpleinv.dto.CustomerDTO.CustomerRequestDTO;
import com.example.simpleinv.dto.CustomerDTO.CustomerResponseDTO;
import com.example.simpleinv.model.Customer;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/customer/all", method = RequestMethod.GET, produces = "application/json")
    public List<CustomerResponseDTO> getAllCustomer(@RequestHeader(value = "Authorization") String token){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/customer/all");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return customerService.getAllCustomer();
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    public CustomerResponseDTO getCustomerId(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/customer/{id}}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return customerService.getCustomerId(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public CustomerResponseDTO updateCustomer(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id, @RequestBody CustomerRequestDTO request){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/customer/update/{id}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return customerService.updateCustomer(id, request);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST,produces = "application/json")
    public CustomerResponseDTO createCustomer(@RequestHeader(value = "Authorization") String token,@RequestBody CustomerRequestDTO request){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/customer/create");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return customerService.createCustomer(request);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public CustomerResponseDTO deleteCustomer(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/customer/delete/{id}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return customerService.deleteCustomer(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    /*@RequestMapping(value = "/customer/search",method = RequestMethod.GET, produces = "application/json")
    public Customer findCustomerName(@RequestParam String name){
        return customerService.findCustomerName(name);
    }*/
}
