package com.baya.smartfarm.contract;

import com.baya.smartfarm.common.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ContractDto extends BaseDto implements Serializable {

    private String contractName;
    private String description;
    private String contractType;
    private LocalDate dateSigned;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long sponsorId;
    private String farmerNationalId;
}
