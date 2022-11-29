package com.morshed.todo.task.repository;

import com.morshed.todo.task.model.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskDetailsRepository extends JpaRepository<TaskDetails, UUID> {
}
