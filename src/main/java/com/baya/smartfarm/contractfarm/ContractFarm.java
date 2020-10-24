package com.baya.smartfarm.contractfarm;

import com.baya.smartfarm.common.BaseDto;

import java.time.LocalDate;

public class ContractFarm extends BaseDto {

  private String contractName;
  private String contractSpecification;
  private LocalDate signingDate;
  private String signee;

}
