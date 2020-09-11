package com.baya.smartfarm.sponsor.service;

import com.baya.smartfarm.sponsor.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {

    Optional<Sponsor> findById(Long id);

}
