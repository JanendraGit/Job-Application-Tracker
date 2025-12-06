package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.util.List;

@Data
public class InterviewListResponse {
    private List<InterviewResponse> interviews;
}
