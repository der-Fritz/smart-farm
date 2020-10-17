package com.baya.smartfarm.contractfarmer.service;

import com.baya.smartfarm.contractfarmer.ContractFarmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractServiceRepository extends JpaRepository<ContractFarmer,Long> {
  ContractFarmer findByContractId(Long contractId);
  ContractFarmer findByFarmerId(String farmerId);
  ContractFarmer findByContractorId(Long contractorId);


}
