package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;
import org.example.jobapplicationtracker.model.InterviewStatus;

import java.time.LocalDateTime;

@Data
public class InterviewResponse {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String location;
    private InterviewStatus interviewStatus;
    private String notes;
    private Long applicationId;
}
