package com.example.simpleinv.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "checkout_table")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer checkoutId;
    private Integer checkoutItemId;
    //private String checkoutItemName;
    //private String checkoutItemType;
    private Integer checkoutItemQty;
    //private Integer checkoutItemPrice;
    private Integer checkoutTotal;
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer checkoutCustId;
    //private Integer checkoutCartId;
    //private boolean checkItemDeleted;
   // private Integer itemId;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "itemId")
    //@OneToMany(fetch = FetchType.LAZY,mappedBy = "checkout")
    //private Item item;
}
