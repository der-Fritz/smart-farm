package com.baya.smartfarm.farm.service;

import com.baya.smartfarm.farm.Department;
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
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    @Override
    public Department register(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findByDeptName(String deptName) {
        return departmentRepository.findByDeptName(deptName);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Long total() {
        return departmentRepository.count();
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable).getContent();
    }
}
