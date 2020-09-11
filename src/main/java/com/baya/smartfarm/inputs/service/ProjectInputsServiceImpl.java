package com.baya.smartfarm.inputs.service;

import com.baya.smartfarm.inputs.ProjectInputs;
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
public class ProjectInputsServiceImpl implements ProjectInputsService{

    private final ProjectInputsRepository projectInputsRepository;

    @Override
    public ProjectInputs register(ProjectInputs projectInputs) {
        return projectInputsRepository.save(projectInputs);
    }

    @Override
    public Optional<ProjectInputs> findByName(String name) {
        return projectInputsRepository.findByName(name);
    }

    @Override
    public Optional<ProjectInputs> findBySerialNo(String serialNo) {
        return projectInputsRepository.findBySerialNo(serialNo);
    }

    @Override
    public Long total() {
        return projectInputsRepository.count();
    }

    @Override
    public ProjectInputs update(ProjectInputs projectInputs) {
        return projectInputsRepository.save(projectInputs);
    }

    @Override
    public List<ProjectInputs> findAll(Pageable pageable) {
        return projectInputsRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<ProjectInputs> findById(Long id) {
        return Optional.empty();
    }
}
