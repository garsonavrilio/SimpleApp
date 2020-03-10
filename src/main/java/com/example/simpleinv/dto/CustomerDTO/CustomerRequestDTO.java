package com.example.simpleinv.dto.CustomerDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class CustomerRequestDTO {
    private Integer custId;
    private String custName;
    private String custAddress;
}
