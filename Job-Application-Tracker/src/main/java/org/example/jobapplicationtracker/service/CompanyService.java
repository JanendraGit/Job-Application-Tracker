package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.Exception.CompanyNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.CompanyDTO;
import org.example.jobapplicationtracker.controller.Request.CreateCompanyRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateCompanyRequest;

import java.util.List;

public interface CompanyService {
    CompanyDTO addCompany(CreateCompanyRequest createCompanyRequest) throws CompanyNotFoundException;
    void updateCompany(Long id, UpdateCompanyRequest updateCompanyRequest) throws CompanyNotFoundException;
    void deleteCompany(Long id) throws CompanyNotFoundException;
    CompanyDTO getCompanyById(Long id) throws CompanyNotFoundException;
    List<CompanyDTO> getAllCompanies() throws CompanyNotFoundException;
}
