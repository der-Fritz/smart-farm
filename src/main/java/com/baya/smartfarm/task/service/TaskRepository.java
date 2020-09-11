package com.baya.smartfarm.task.service;

import com.baya.smartfarm.task.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
    Optional<Tasks> findById(Long id);
}
