package com.example.simpleinv.dto.ItemDTO.converter;

import com.example.simpleinv.dto.ItemDTO.ItemResponseDTO;
import com.example.simpleinv.model.Item;

public class ItemToResponseConverter {
    public final static ItemResponseDTO convert(Item item){
        return new ItemResponseDTO(item.getItemId(),item.getItemName(),item.getItemType(),item.getItemPrice(),item.getItemSellPrice(),item.getItemQty(),item.isDeleted());
    }
}
