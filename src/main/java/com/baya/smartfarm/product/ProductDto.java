package com.baya.smartfarm.product;

import com.baya.smartfarm.batches.Batches;
import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.project.Project;

import java.io.Serializable;

public class ProductDto extends BaseDto implements Serializable {

    private String productCode;
    private String name;
    private String description;
    private double quantity;
    private double price;
    private Project project;
    private Batches batches;

}
