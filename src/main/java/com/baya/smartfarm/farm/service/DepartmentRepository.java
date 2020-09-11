package com.baya.smartfarm.farm.service;

import com.baya.smartfarm.farm.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDeptName(String deptName);
}
