package org.example.jobapplicationtracker.service.impl;

import org.example.jobapplicationtracker.Exception.CompanyNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.CompanyDTO;
import org.example.jobapplicationtracker.controller.Request.CreateCompanyRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateCompanyRequest;
import org.example.jobapplicationtracker.controller.Response.CompanyListResponse;
import org.example.jobapplicationtracker.model.Company;
import org.example.jobapplicationtracker.repository.CompanyRepository;
import org.example.jobapplicationtracker.service.CompanyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompanyImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public CreateCompanyRequest addCompany(CreateCompanyRequest createCompanyRequest) throws CompanyNotFoundException {
        Optional<Company> companyOptional = companyRepository.findByName(createCompanyRequest.getName());
        if (companyOptional.isPresent()) {
            throw new CompanyNotFoundException("Company with name " + createCompanyRequest.getName() + " already exists");
        }
        Company newCompany = new Company();
        newCompany.setName(createCompanyRequest.getName());
        newCompany.setWebsite(createCompanyRequest.getWebsite());
        newCompany.setDescription(createCompanyRequest.getDescription());
        companyRepository.save(newCompany);
        return createCompanyRequest;
    }

    @Override
    public void updateCompany(Long id, UpdateCompanyRequest updateCompanyRequest) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException("Company with id " + id + " not found"));
        company.setName(updateCompanyRequest.getName());
        company.setWebsite(updateCompanyRequest.getWebsite());
        company.setDescription(updateCompanyRequest.getDescription());
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException("Company with id " + id + " not found"));
        companyRepository.delete(company);
    }

    @Override
    public CompanyDTO companyGetById(Long id) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException("Company with id " + id + " not found"));
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setWebsite(company.getWebsite());
        companyDTO.setDescription(company.getDescription());
        return companyDTO;
    }

    @Override
    public void updateCompanyName(Long id, String companyName) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException("Company with id " + id + " not found"));
        company.setName(companyName);
        companyRepository.save(company);
    }

    @Override
    public void updateCompanyWebsite(Long id, String website) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException("Company with id " + id + " not found"));
        company.setWebsite(website);
        companyRepository.save(company);
    }

    @Override
    public void updateCompanyDescription(Long id, String description) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(()-> new CompanyNotFoundException("Company with id " + id + " not found"));
        company.setDescription(description);
        companyRepository.save(company);
    }@Override
    public List<CompanyListResponse> getAllUsers() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyListResponse> companyListResponses = companies.stream().map(company -> CompanyListResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .website(company.getWebsite())
                .description(company.getDescription())
                .build()).collect(Collectors.toList());
        return companyListResponses;
    }


}
