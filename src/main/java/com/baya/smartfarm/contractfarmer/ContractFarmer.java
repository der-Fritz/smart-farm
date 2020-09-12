package com.baya.smartfarm.contractfarmer;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Entity
@Table(name = "contractorfarmers", indexes = {@Index(name = "indx_contractorfarmers", columnList = "contId", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContractFarmer  {

  @Id
  @Column(name = "contId")
  private Long contractId;

 @Column(name = "farmer_id",  length = 50, nullable = false)
  private String farmerId;

  @Column(name = "contract_id", length = 50, nullable = false)
  private String contractorId;

}
