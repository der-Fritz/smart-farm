package com.baya.smartfarm.inputs;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.merchant.SupplierDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectInputsDto extends BaseDto implements Serializable {

    private String serialNo;
    private String name;
    private double quantity;
    private double price;
    private SupplierDto supplier;
}
