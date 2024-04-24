package com.cauzy.tasklist.repository;

import com.cauzy.tasklist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
