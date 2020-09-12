package com.baya.smartfarm.contractfarmer.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class ContractFarmerDto implements Serializable {
  private Long contractId;
  private String farmerId;
  private String contractorId;
}
