package com.example.simpleinv.controller;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutRequestDTO;
import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.dto.ItemDTO.ItemRequestDTO;
import com.example.simpleinv.dto.ItemDTO.ItemResponseDTO;
import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import com.example.simpleinv.dto.itemToCheckoutDTO.ItemToCheckoutRequestDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Item;
import com.example.simpleinv.services.Services.PermissionService;
import com.example.simpleinv.services.item.ItemServices;
import com.example.simpleinv.services.permissionrole.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ItemController {

    @Autowired
    ItemServices itemService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/item/all",method = RequestMethod.GET, produces = "application/json")
    public List<ItemResponseDTO> getAllItem(@RequestHeader(value = "Authorization") String token){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/all");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.getAllItem();
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/item/create", method = RequestMethod.POST, produces = "application/json")
    public ItemResponseDTO newItem(@RequestHeader(value = "Authorization") String token,@RequestBody ItemRequestDTO request){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/create");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.newItem(request);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = "application/json")
    public ItemResponseDTO findItemId(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/{id}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.findItemId(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ItemResponseDTO updateItem(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id,@RequestBody ItemRequestDTO request){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/update/{id}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.updateItem(id,request);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ItemResponseDTO deleteItem(@RequestHeader(value = "Authorization") String token,@PathVariable Integer id){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/delete/{id}");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.deleteItem(id);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/item/search", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Item> findItemName(@RequestHeader(value = "Authorization") String token,@RequestParam String name){
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/search");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.findItemName(name);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }

    @RequestMapping(value = "/item/shopping", method = RequestMethod.POST, produces = "application/json")
    public CheckoutResponseDTO itemToCheckout(@RequestHeader(value = "Authorization") String token,@RequestBody ItemToCheckoutRequestDTO request){
        //System.out.println(request);
        String username = permissionService.getUsernameByToken(token);
        Integer roleId = permissionService.getRoleByUsername(username);
        List<Integer> listOfRolePermission = permissionService.rolePermission(roleId);
        Integer url = permissionService.searchUrlId("/item/shopping");
        boolean flag = listOfRolePermission.contains(url);
        if (flag) {
            return itemService.itemToCheckout(request,username);
        } else {
            throw new IllegalArgumentException("You Do Not have Permission to continue this process");
        }
    }


}
