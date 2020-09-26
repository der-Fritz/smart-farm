package com.baya.smartfarm.merchant.service;

import com.baya.smartfarm.merchant.Merchant;
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
public class MerchantServiceImpl implements MerchantService {

    private  final MerchantRepository merchantRepository;

    @Override
    public Merchant register(Merchant merchant) {
        log.info("Register Merchant :{}", merchant);
        return merchantRepository.save(merchant);
    }

    @Override

    public Optional<Merchant> findById(Long id) {
        return merchantRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        merchantRepository.deleteById(id);

    }


    @Override
    public Optional<Merchant> findByName(String name) {
        return merchantRepository.findByName(name);
    }

    @Override
    public Long total() {
        return merchantRepository.count();
    }

    @Override
    public Merchant update(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public List<Merchant> findAll(Pageable pageable) {
        return merchantRepository.findAll(pageable).getContent();
    }
}
