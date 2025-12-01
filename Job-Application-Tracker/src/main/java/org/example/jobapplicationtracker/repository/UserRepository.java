package org.example.jobapplicationtracker.repository;

import org.example.jobapplicationtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
