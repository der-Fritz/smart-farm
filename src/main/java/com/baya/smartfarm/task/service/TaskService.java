package com.baya.smartfarm.task.service;

import com.baya.smartfarm.task.Tasks;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService  {
    Tasks register(Tasks tasks);
    Tasks update(Tasks tasks);
    Optional<Tasks> findById(Long id);
    Optional<Tasks> findByTaskName(String taskName);
    Long total();
    List<Tasks> findAll(Pageable pageable);
}
