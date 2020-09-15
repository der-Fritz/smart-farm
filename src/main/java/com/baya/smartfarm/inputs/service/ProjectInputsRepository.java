package com.baya.smartfarm.inputs.service;

import com.baya.smartfarm.inputs.ProjectInputs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectInputsRepository extends JpaRepository<ProjectInputs, Long> {
    Optional<ProjectInputs> findBySerialNo(String serialNo);
    Optional<ProjectInputs> findByName(String name);
}
