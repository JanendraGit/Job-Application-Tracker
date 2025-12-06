package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationStatusHistoryListResponse {
    private List<ApplicationStatusHistoryResponse> statusHistories;
}
