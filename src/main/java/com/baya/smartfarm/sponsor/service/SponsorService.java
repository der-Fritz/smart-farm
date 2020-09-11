package com.baya.smartfarm.sponsor.service;

import com.baya.smartfarm.sponsor.Sponsor;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SponsorService {

    Sponsor register(Sponsor sponsor);

    Sponsor update(Sponsor sponsor);

    Long total();

    Sponsor delete(Sponsor sponsor);

    List<Sponsor> findAll(Pageable pageable);

}
