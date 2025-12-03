package org.example.jobapplicationtracker.controller.Request;

import lombok.Data;

@Data
public class CreateCompanyRequest {
    private Long id;
    private String name;
    private String website;
    private String description;
}
