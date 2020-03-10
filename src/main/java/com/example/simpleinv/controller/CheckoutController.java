package com.example.simpleinv.controller;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.checkout.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/checkout/all", method = RequestMethod.GET, produces = "application/json")
    public List<CheckoutResponseDTO> getAllCheckout(@RequestHeader(value = "Authorization") String token){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/checkout/all");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return checkoutService.getAllCheckout();
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/checkout/delete", method = RequestMethod.DELETE, produces = "application/json")
    public CheckoutResponseDTO deleteCheckout(@RequestHeader(value = "Authorization") String token,@RequestParam Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/checkout/delete");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return checkoutService.deleteCheckout(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/checkout/", method = RequestMethod.GET, produces = "application/json")
    public List<CheckoutResponseDTO> getCheckoutById(@RequestHeader(value = "Authorization") String token,@RequestParam Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/checkout/");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return checkoutService.getCheckoutById(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

}
