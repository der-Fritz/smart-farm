package com.baya.smartfarm.task.service;

import com.baya.smartfarm.task.Tasks;
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
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Tasks register(Tasks tasks) {
        return taskRepository.save(tasks);
    }

    @Override
    public Tasks update(Tasks tasks) {
        return taskRepository.save(tasks);
    }

    @Override
    public Optional<Tasks> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Tasks> findByTaskName(String taskName) {
        return Optional.empty();
    }

    @Override
    public Long total() {
        return null;
    }

    @Override
    public List<Tasks> findAll(Pageable pageable) {
        return null;
    }
}
