package com.baya.smartfarm.contract.service;

import com.baya.smartfarm.contract.Contract;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    Contract register(Contract contract);

    Contract update(Contract contract);

    Optional<Contract> findByContractName(String contractName);

    Long total();

    List<Contract> findAll(Pageable pageable);

}
