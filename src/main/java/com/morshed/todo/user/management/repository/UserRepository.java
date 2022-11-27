package com.morshed.todo.user.management.repository;

import com.morshed.todo.user.management.model.User;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends ListPagingAndSortingRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
