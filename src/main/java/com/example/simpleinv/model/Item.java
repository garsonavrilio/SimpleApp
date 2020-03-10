package com.example.simpleinv.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "item_table")
public class Item implements Serializable {


    private static final long serialVersionUID = 4070369638807376604L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer itemId;
    private String itemName;
    private String itemType;
    private Integer itemPrice;
    private Integer itemSellPrice;
    private Integer itemQty;
    private boolean isDeleted=false;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "checkout_id")
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "item",cascade = CascadeType.ALL)
    //private List<Checkout> checkout;
}
