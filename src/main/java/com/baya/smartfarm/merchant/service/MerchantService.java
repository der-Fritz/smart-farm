package com.baya.smartfarm.merchant.service;

import com.baya.smartfarm.merchant.Merchant;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    Merchant register(Merchant merchant);

    Optional<Merchant> findById(Long id);

    Optional<Merchant> findByName(String name);

    Long total();

    Merchant update(Merchant merchant);

    List<Merchant> findAll(Pageable pageable);
}
