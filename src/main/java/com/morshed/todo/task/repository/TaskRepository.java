package com.morshed.todo.task.repository;

import com.morshed.todo.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
