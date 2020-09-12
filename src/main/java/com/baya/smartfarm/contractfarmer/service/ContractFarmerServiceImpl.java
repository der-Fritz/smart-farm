package com.baya.smartfarm.contractfarmer.service;

import com.baya.smartfarm.contract.Contract;
import com.baya.smartfarm.contractfarmer.ContractFarmer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)

public class ContractFarmerServiceImpl implements ContractFarmerService{

  private final ContractServiceRepository serviceRepository;

  @Override
  public ContractFarmer findByContractId(Long contractId) {
    return serviceRepository.findByContractId(contractId);
  }

  @Override
  public ContractFarmer findByFarmerId(String farmerId) {
    return serviceRepository.findByFarmerId(farmerId);
  }

  @Override
  public ContractFarmer findByContractorId(Long contractorId) {
    return serviceRepository.findByContractorId(contractorId);
  }

  @Override
  public ContractFarmer register(ContractFarmer contractFarmer) {
    return serviceRepository.save(contractFarmer);
  }

  @Override
  public ContractFarmer update(ContractFarmer contractFarmer) {
    return serviceRepository.save(contractFarmer);
  }

  @Override
  public Long total() {
    return null;
  }

  @Override
  public List<ContractFarmer> findAll(Pageable pageable) {
    return serviceRepository.findAll(pageable).getContent();
  }
}
