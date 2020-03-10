package com.example.simpleinv.dto.ItemDTO.converter;

import com.example.simpleinv.dto.ItemDTO.ItemRequestDTO;
import com.example.simpleinv.dto.ItemDTO.ItemResponseDTO;
import com.example.simpleinv.model.Item;

public class ItemRequestToItemConverter {
    public final static Item convertCreate(ItemRequestDTO request){
        Item item = new Item();
        item.setItemName(request.getItemName());
        item.setItemPrice(request.getItemPrice());
        item.setItemQty(request.getItemQty());
        item.setItemSellPrice(request.getItemSellPrice());
        item.setItemType(request.getItemType());
        return item;
    }

    public final static Item convertUpdate(ItemRequestDTO request){
        Item item = new Item();
        item.setItemId(request.getItemId());
        item.setItemName(request.getItemName());
        item.setItemType(request.getItemType());
        item.setItemPrice(request.getItemPrice());
        item.setItemSellPrice(request.getItemSellPrice());
        item.setItemQty(request.getItemQty());
        //item.setDeleted(request.isDeleted());
        return item;
    }

    public final static Item updateStock(Item z){
        Item item = new Item();
        item.setItemId(z.getItemId());
        item.setItemName(z.getItemName());
        item.setItemType(z.getItemType());
        item.setItemPrice(z.getItemPrice());
        item.setItemSellPrice(z.getItemSellPrice());
        item.setItemQty(z.getItemQty());
        //item.setDeleted(z.isDeleted());
        return item;
    }
}
