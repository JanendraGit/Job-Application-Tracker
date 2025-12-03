package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.Exception.CompanyNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.CompanyDTO;
import org.example.jobapplicationtracker.controller.Request.CreateCompanyRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateCompanyRequest;
import org.example.jobapplicationtracker.controller.Response.CompanyListResponse;

import java.util.List;

public interface CompanyService {
    CreateCompanyRequest addCompany(CreateCompanyRequest createCompanyRequest)throws CompanyNotFoundException;
    void updateCompany(Long id, UpdateCompanyRequest updateCompanyRequest) throws CompanyNotFoundException;
    void deleteCompany(Long id) throws CompanyNotFoundException;
    CompanyDTO companyGetById(Long id) throws CompanyNotFoundException;
    void updateCompanyName(Long id, String companyName) throws CompanyNotFoundException;
    void updateCompanyWebsite(Long id, String website) throws CompanyNotFoundException;
    void updateCompanyDescription(Long id, String description) throws CompanyNotFoundException;
    List<CompanyListResponse> getAllUsers();

}



