package com.baya.smartfarm.contractfarmer;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Table(name = "contractfarmers", indexes = {@Index(name = "indx_contractfarmer", columnList = "contract_id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContractFarmer extends BaseEntity {

  @Column(name = "contract_id", length = 50, unique = false, nullable = false)
  private String contractId;

  @Column(name = "farmer_id", length = 50, nullable = false)
  private String farmerId;

  @Column(name = "contract_id", length = 50, nullable = false)
  private String contractorId;

}
