package com.baya.smartfarm.project.service;

import com.baya.smartfarm.project.Manager;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    Manager register(Manager manager);

    Manager update(Manager manager);

    Manager delete(Manager manager);

    Optional<Manager> findById(Long id);

    Long total();

    List<Manager> findAll(Pageable pageable);

}
