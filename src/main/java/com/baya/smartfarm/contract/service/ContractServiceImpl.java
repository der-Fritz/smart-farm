package com.baya.smartfarm.contract.service;

import com.baya.smartfarm.contract.Contract;
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

    @Override
    public Contract register(Contract contract) {
        return contractRepository.save(contract);
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
