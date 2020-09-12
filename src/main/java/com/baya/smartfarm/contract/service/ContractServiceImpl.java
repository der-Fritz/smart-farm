package com.baya.smartfarm.contract.service;

import com.baya.smartfarm.contract.Contract;
import com.baya.smartfarm.contractfarmer.ContractFarmer;
import com.baya.smartfarm.contractfarmer.dto.ContractFarmerDto;
import com.baya.smartfarm.contractfarmer.service.ContractFarmerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractFarmerServiceImpl contractFarmerService;

    @Override
    public Contract register(Contract contract) {
      log.info("Creating a new contract: {}", contract);
      Contract contract1= contractRepository.save(contract);
      ContractFarmer contractFarmer = new ContractFarmer();
      contractFarmer.setContractId(contract1.getId());
      contractFarmer.setContractorId(String.valueOf(contract1.getSponsorId()));
      contractFarmer.setFarmerId(contract1.getFarmerNationalId());
      log.info("Creating a new contract: {}", contract1);
      contractFarmerService.register(contractFarmer);

      return contract1;

    }

    @Override
    public Contract update(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findByContractName(String contractName) {
        return contractRepository.findByContractName(contractName);
    }

    @Override
    public Long total() {
        return contractRepository.count();
    }

    @Override
    public List<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable).getContent();
    }
}
