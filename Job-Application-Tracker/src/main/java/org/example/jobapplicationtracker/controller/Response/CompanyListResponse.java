package org.example.jobapplicationtracker.controller.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyListResponse {
    private Long id;
    private String name;
    private String website;
    private String description;
}
