package org.example.jobapplicationtracker.repository;

import org.example.jobapplicationtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    static Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}