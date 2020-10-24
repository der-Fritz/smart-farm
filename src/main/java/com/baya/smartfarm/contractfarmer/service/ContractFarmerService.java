package com.baya.smartfarm.contractfarmer.service;

import com.baya.smartfarm.contract.Contract;
import com.baya.smartfarm.contractfarmer.ContractFarmer;
import com.baya.smartfarm.contractfarmer.dto.ContractFarmerDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContractFarmerService {
  ContractFarmer findByContractId(Long contractId);
  ContractFarmer findByFarmerId(String farmerId);
  ContractFarmer findByContractorId(Long contractorId);
  ContractFarmer register(ContractFarmer contractFarmer);
  ContractFarmer update(ContractFarmer contractFarmer);
  Long total();
  List<ContractFarmer> findAll(Pageable pageable);

}
