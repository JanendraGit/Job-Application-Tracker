package org.example.jobapplicationtracker.controller;

import lombok.Data;
import org.example.jobapplicationtracker.Exception.CompanyNotFoundException;
import org.example.jobapplicationtracker.controller.DTO.CompanyDTO;
import org.example.jobapplicationtracker.controller.Request.CreateCompanyRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateCompanyRequest;
import org.example.jobapplicationtracker.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@Data
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/add")
    public CompanyDTO addCompany(@RequestBody CreateCompanyRequest createCompanyRequest) throws CompanyNotFoundException {
        return companyService.addCompany(createCompanyRequest);
    }

    @PostMapping
    public void UpdateCompany(@PathVariable Long id, @RequestBody UpdateCompanyRequest updateCompanyRequest){
        companyService.updateCompany(id, updateCompanyRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

    @GetMapping
    public List<CompanyDTO> getAllCompanies(){
        return companyService.getAllCompanies();
    }

}
