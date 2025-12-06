package org.example.jobapplicationtracker.service.impl;

import lombok.AllArgsConstructor;
import org.example.jobapplicationtracker.Exception.CompanyNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.CompanyDTO;
import org.example.jobapplicationtracker.controller.Request.CreateCompanyRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateCompanyRequest;
import org.example.jobapplicationtracker.model.Company;
import org.example.jobapplicationtracker.repository.CompanyRepository;
import org.example.jobapplicationtracker.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public CompanyDTO addCompany(CreateCompanyRequest createCompanyRequest) throws CompanyNotFoundException {
        Optional<Company> companyOptional = companyRepository.findByName(createCompanyRequest.getName());
        if (companyOptional.isPresent()) {
            throw new CompanyNotFoundException("Company with name " + createCompanyRequest.getName() + " already exists");
        }
        Company company = new Company();
        company.setName(createCompanyRequest.getName());
        company.setWebsite(createCompanyRequest.getWebsite());
        company.setDescription(createCompanyRequest.getDescription());
        Company company1 = companyRepository.save(company);
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company1.getId());
        companyDTO.setName(company1.getName());
        companyDTO.setWebsite(company1.getWebsite());
        companyDTO.setDescription(company1.getDescription());
        return companyDTO;
    }

    @Override
    public void updateCompany(Long id, UpdateCompanyRequest updateCompanyRequest) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found with id: " + id));
        company.setName(updateCompanyRequest.getName());
        company.setWebsite(updateCompanyRequest.getWebsite());
        company.setDescription(updateCompanyRequest.getDescription());
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found with id: " + id));
        companyRepository.delete(company);
    }

    @Override
    public CompanyDTO getCompanyById(Long id) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company not found with id: " + id));
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setWebsite(company.getWebsite());
        companyDTO.setDescription(company.getDescription());
        return companyDTO;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() throws CompanyNotFoundException {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = companies.stream().map(company -> CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .website(company.getWebsite())
                .description(company.getDescription()).build())
                .collect(Collectors.toList());
        return companyDTOS;
    }
}
