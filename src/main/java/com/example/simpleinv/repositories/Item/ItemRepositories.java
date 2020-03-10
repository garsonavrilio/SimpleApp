package com.example.simpleinv.repositories.Item;

import com.example.simpleinv.dto.ItemDTO.ItemResponseDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Customer;
import com.example.simpleinv.model.Item;
import org.hibernate.annotations.Check;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemRepositories extends CrudRepository<Item, Integer> {
    @Query("SELECT c FROM Item c WHERE c.itemName = ?1")
    List<Item> findByName(String name);

    //@Transactional
    //@Query(value = "INSERT INTO Checkout(checkout_item_name, checkout_item_price, checkout_item_qty, checkout_item_type) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    //void ItemToCheckout(String name, String type, Integer qty, Integer price);
}
