package com.baya.smartfarm.project.service;

import com.baya.smartfarm.project.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Optional<Manager> findByMsisdn(String msisdn);

}
