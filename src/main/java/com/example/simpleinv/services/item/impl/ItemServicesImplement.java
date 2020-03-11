package com.example.simpleinv.services.item.impl;

//import com.example.simpleinv.config.JwtTokenUtil;
import com.example.simpleinv.dto.CheckoutDTO.CheckoutRequestDTO;
import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.dto.CheckoutDTO.converter.CheckoutRequestToCheckoutConverter;
import com.example.simpleinv.dto.CheckoutDTO.converter.CheckoutToResponseConverter;
import com.example.simpleinv.dto.ItemDTO.ItemRequestDTO;
import com.example.simpleinv.dto.ItemDTO.ItemResponseDTO;
import com.example.simpleinv.dto.ItemDTO.converter.ItemRequestToItemConverter;
import com.example.simpleinv.dto.ItemDTO.converter.ItemToResponseConverter;
import com.example.simpleinv.dto.PermissionRoleDTO.PermissionRoleResponseDTO;
import com.example.simpleinv.dto.itemToCheckoutDTO.ItemToCheckoutRequestDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Customer;
import com.example.simpleinv.model.Item;
import com.example.simpleinv.model.TransactionDetails;
import com.example.simpleinv.model.User;
import com.example.simpleinv.repositories.Admin.UserRepositories;
import com.example.simpleinv.repositories.Checkout.CheckoutRepositories;
import com.example.simpleinv.repositories.Customer.CustomerRepositories;
import com.example.simpleinv.repositories.Item.ItemRepositories;
import com.example.simpleinv.services.item.ItemServices;
import com.example.simpleinv.services.permissionrole.PermissionRoleService;
import javax.swing.text.html.Option;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemServicesImplement implements ItemServices {

  @Autowired
  private ItemRepositories itemRepo;

  @Autowired
  private CheckoutRepositories checkoutRepo;

  @Autowired
  private CustomerRepositories customerRepo;

  @Autowired
  private PermissionRoleService permissionRoleService;

//  @Autowired
//  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserRepositories userRepo;

  @Override
  public List<ItemResponseDTO> getAllItem() {
    return StreamSupport.stream(itemRepo.findAll().spliterator(), false)
        .map(ItemToResponseConverter::convert).collect(Collectors.toList());
  }

  @Override
  public List<Item> findItemName(String name) {
    return itemRepo.findByName(name);
  }

  @Override
  public ItemResponseDTO newItem(ItemRequestDTO request) {
    if(request.getItemQty()<0 || request.getItemPrice()<0){
      throw new IllegalArgumentException("Invalid Quantity or Price");
    }
    Item item = ItemRequestToItemConverter.convertCreate(request);
    return ItemToResponseConverter.convert(itemRepo.save(item));
  }

  @Override
  public ItemResponseDTO findItemId(Integer id) {
    Optional<Item> temp = itemRepo.findById(id);
    if(temp.isPresent()) {
      return ItemToResponseConverter.convert(temp.get());
    }
    else {
      throw new BadCredentialsException("Cannot Find the Item you Search");
    }
  }

  @Override
  public ItemResponseDTO updateItem(Integer id, ItemRequestDTO request) {
    boolean flag = itemRepo.existsById(id);
    if (flag) {
      Item item = ItemRequestToItemConverter.convertUpdate(request);
      item.setItemId(id);
      return ItemToResponseConverter.convert(itemRepo.save(item));
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public ItemResponseDTO deleteItem(Integer id) {
    Optional<Item> temp = itemRepo.findById(id);
    Item newItem = temp
        .orElseThrow(() -> new IllegalArgumentException("Index Delete Item Not Found"));
    newItem.setDeleted(true);
    itemRepo.save(newItem);
    return ItemToResponseConverter.convert(newItem);
  }

//  @Override
//  public CheckoutResponseDTO itemToCheckout(ItemToCheckoutRequestDTO request, String username) {
//    Optional<Item> item = itemRepo.findById(request.getItemToCheckoutItemId());
//    System.out.println(request.getItemToCheckoutUserId());
//    System.out.println(request.getItemToCheckoutItemQty());
//    System.out.println(request.getItemToCheckoutItemId());
//    Optional<User> users = userRepo.findUserByUsername(username);
//    User user = users.orElseThrow(()->new IllegalArgumentException("User is empty"));
//    //Item updateQty = item.orElseThrow(()->new IllegalArgumentException("Not Found Item To Checkout"));
//    Item updateQty = item.get();
//    if (!item.isPresent()) {
//      throw new IllegalArgumentException();
//    } else {
//      if (updateQty.isDeleted()) {
//        throw new IllegalArgumentException("The Item You Selected was deleted by owner");
//      } else {
//        if (updateQty.getItemQty() - request.getItemToCheckoutItemQty() >= 0) {
//          updateQty.setItemQty(updateQty.getItemQty() - request.getItemToCheckoutItemQty());
//          ItemRequestToItemConverter.updateStock(updateQty);
//          //Item itemFound = item.orElseThrow( () -> new RuntimeException("salah"));
//          Checkout c = new Checkout();
//          c.setCheckoutItemId(updateQty.getItemId());
//          c.setCheckoutItemQty(request.getItemToCheckoutItemQty());
//          c.setCheckoutTotal(updateQty.getItemPrice() * request.getItemToCheckoutItemQty());
//          c.setCheckoutCustId(user.getUserId());
//          Checkout a = CheckoutRequestToCheckoutConverter.convertCreate(checkoutRepo.save(c));
//
//          return CheckoutToResponseConverter.convert(a);
//        } else {
//          throw new IllegalArgumentException("Quantity is not valid tho");
//        }
//      }
//    }
//  }


}
