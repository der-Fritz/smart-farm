package com.baya.smartfarm.sponsor.service;

import com.baya.smartfarm.sponsor.Sponsor;
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
public class SponsorServiceImpl implements SponsorService{

    private final SponsorRepository sponsorRepository;

    @Override
    public Sponsor register(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Sponsor update(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Long total() {
        return sponsorRepository.count();
    }

    @Override
    public Sponsor delete(Sponsor sponsor) {
        return null;
    }

    @Override
    public List<Sponsor> findAll(Pageable pageable) {
        return sponsorRepository.findAll(pageable).getContent();
    }
}
