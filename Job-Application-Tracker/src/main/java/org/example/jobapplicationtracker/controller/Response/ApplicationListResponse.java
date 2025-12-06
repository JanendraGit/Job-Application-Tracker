package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationListResponse {
    private List<ApplicationResponse> applications;
}
