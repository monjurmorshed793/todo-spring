package com.morshed.todo.task.repository;

import com.morshed.todo.task.model.TaskRevision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRevisionRepository extends JpaRepository<TaskRevision, UUID> {
}
