package com.baya.smartfarm.merchant.service;

import com.baya.smartfarm.merchant.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findByMsisdn(String msisdn);

    Optional<Supplier> findByName(String name);
}
