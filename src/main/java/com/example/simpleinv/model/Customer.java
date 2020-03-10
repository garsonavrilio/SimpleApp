package com.example.simpleinv.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;
    private String custName;
    private String custAddress;
}
