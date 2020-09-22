package com.baya.smartfarm.merchant.service;

import com.baya.smartfarm.merchant.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Optional<Merchant> findByMsisdn(String msisdn);

    Optional<Merchant> findByName(String name);
}
