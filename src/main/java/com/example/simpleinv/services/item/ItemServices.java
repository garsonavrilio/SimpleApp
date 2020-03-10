package com.example.simpleinv.services.item;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutRequestDTO;
import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.dto.ItemDTO.ItemRequestDTO;
import com.example.simpleinv.dto.ItemDTO.ItemResponseDTO;
import com.example.simpleinv.dto.itemToCheckoutDTO.ItemToCheckoutRequestDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Item;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ItemServices {
    List<ItemResponseDTO> getAllItem();
    List<Item> findItemName(String name);
    ItemResponseDTO newItem(ItemRequestDTO request);
    ItemResponseDTO findItemId(Integer id);
    ItemResponseDTO updateItem(Integer id,ItemRequestDTO request);
    ItemResponseDTO deleteItem(Integer id);
    CheckoutResponseDTO itemToCheckout(ItemToCheckoutRequestDTO request, String Username);
}
