package com.baya.smartfarm.project.service;

import com.baya.smartfarm.project.Manager;
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
public class ManagerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

    @Override
    public Manager register(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return null;
    }

    @Override
    public Manager delete(Manager manager) {
        return null;
    }

    @Override
    public Optional<Manager> findById(Long id) {
        return managerRepository.findById(id);
    }

    @Override
    public Long total() {
        return managerRepository.count();
    }

    @Override
    public List<Manager> findAll(Pageable pageable) {
        return managerRepository.findAll(pageable).getContent();
    }
}
