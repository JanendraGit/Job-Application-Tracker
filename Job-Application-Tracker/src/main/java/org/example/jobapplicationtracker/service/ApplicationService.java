package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.Exception.ApplicationNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.ApplicationDTO;
import org.example.jobapplicationtracker.controller.Request.CreateApplicationRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateApplicationRequest;

import java.util.List;

public interface ApplicationService {
    ApplicationDTO addApplication(CreateApplicationRequest createApplicationRequest);
    void updateApplication(Long id, UpdateApplicationRequest updateApplicationRequest) throws  ApplicationNotFoundException;
    void deleteApplication(Long id) throws ApplicationNotFoundException;
    ApplicationDTO getApplicationById(Long id) throws ApplicationNotFoundException;
    List<ApplicationDTO> getAllApplications();
}
