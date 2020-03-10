package com.example.simpleinv.dto.CustomerDTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class CustomerResponseDTO {

    public CustomerResponseDTO(Integer custId, String custName, String custAddress){
        super();
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
    }
    private Integer custId;
    private String custName;
    private String custAddress;
}
