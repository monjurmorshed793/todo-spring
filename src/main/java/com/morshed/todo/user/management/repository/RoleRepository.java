package com.morshed.todo.user.management.repository;

import com.morshed.todo.user.management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
