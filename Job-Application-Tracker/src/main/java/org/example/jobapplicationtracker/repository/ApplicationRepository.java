package org.example.jobapplicationtracker.repository;

import org.example.jobapplicationtracker.model.Application;
import org.example.jobapplicationtracker.model.Company;
import org.example.jobapplicationtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    Optional<Application> findByJobTitle(String jobTitle);
    Optional<Application> findByJobTitleAndCompanyAndUser(String jobTitle, Company company, User user);
}
