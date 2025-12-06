package org.example.jobapplicationtracker.service.impl;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.ApplicationAlreadyExistsException;
import org.example.jobapplicationtracker.Exception.ApplicationNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.ApplicationDTO;
import org.example.jobapplicationtracker.controller.Request.CreateApplicationRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateApplicationRequest;
import org.example.jobapplicationtracker.model.Application;
import org.example.jobapplicationtracker.repository.ApplicationRepository;
import org.example.jobapplicationtracker.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    @Override
    public ApplicationDTO addApplication(CreateApplicationRequest createApplicationRequest) {
        Optional<Application> optionalApplication = applicationRepository.findByJobTitle(createApplicationRequest.getJobTitle());
        if (optionalApplication.isPresent()) {
            throw new ApplicationAlreadyExistsException("This job title"+createApplicationRequest.getJobTitle()+"already exist");
        }
        Application application = new Application();
        application.setJobTitle(createApplicationRequest.getJobTitle());
        application.setSalary(createApplicationRequest.getSalary());
        application.setLocation(createApplicationRequest.getLocation());
        application.setAppliedDate(createApplicationRequest.getAppliedDate());
        application.setSource(createApplicationRequest.getSource());
        application.setPriority(createApplicationRequest.getPriority());
        application.setCurrentStatus(createApplicationRequest.getCurrentStatus());
        Application application1 = applicationRepository.save(application);

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setLocation(application1.getLocation());
        applicationDTO.setAppliedDate(application1.getAppliedDate());
        applicationDTO.setCurrentStatus(application1.getCurrentStatus());
        applicationDTO.setJobTitle(application1.getJobTitle());
        applicationDTO.setSalary(application1.getSalary());
        applicationDTO.setSource(application1.getSource());
        applicationDTO.setPriority(application1.getPriority());
        return  applicationDTO;
    }

    @Override
    public void updateApplication(Long id, UpdateApplicationRequest updateApplicationRequest) throws ApplicationNotFoundException {
        Application application = applicationRepository.findById(id).orElseThrow(()-> new ApplicationNotFoundException("Application not found"));
        application.setLocation(updateApplicationRequest.getLocation());
        application.setAppliedDate(updateApplicationRequest.getAppliedDate());
        application.setCurrentStatus(updateApplicationRequest.getCurrentStatus());
        application.setJobTitle(updateApplicationRequest.getJobTitle());
        application.setSalary(updateApplicationRequest.getSalary());
        application.setSource(updateApplicationRequest.getSource());
        application.setPriority(updateApplicationRequest.getPriority());
        applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long id) throws ApplicationNotFoundException {
        Application application = applicationRepository.findById(id).orElseThrow(()-> new ApplicationNotFoundException("Application not found"));
        applicationRepository.delete(application);
    }

    @Override
    public ApplicationDTO getApplicationById(Long id) throws ApplicationNotFoundException {
        return null;
    }

    @Override
    public List<ApplicationDTO> getAllApplications() {
        return List.of();
    }
}
