package com.baya.smartfarm.merchant.service;

import com.baya.smartfarm.merchant.Supplier;
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
public class SupplierServiceImpl implements SupplierService{

    private  final SupplierRepository supplierRepository;

    @Override
    public Supplier register(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Optional<Supplier> findByName(String name) {
        return supplierRepository.findByName(name);
    }

    @Override
    public Long total() {
        return supplierRepository.count();
    }

    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> findAll(Pageable pageable) {
        return supplierRepository.findAll(pageable).getContent();
    }
}
