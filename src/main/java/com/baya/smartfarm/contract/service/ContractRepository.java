package com.baya.smartfarm.contract.service;

import com.baya.smartfarm.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Override
    Optional<Contract> findById(Long aLong);

    Optional<Contract> findByContractName(String contractName);
}
