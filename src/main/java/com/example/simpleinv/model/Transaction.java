package com.example.simpleinv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "transaction_table")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;
    //private Integer checkoutId;
    private Integer userId;
    //private String custName;
    //private String custAddress;
    //private Integer adminId;
    private Integer totalAmount;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateTime;
}
