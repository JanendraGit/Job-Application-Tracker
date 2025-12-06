package org.example.jobapplicationtracker.controller.Request;

import lombok.Builder;
import lombok.Data;
import org.example.jobapplicationtracker.model.CurrentStatus;
import org.example.jobapplicationtracker.model.Priority;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdateApplicationRequest {
    private String jobTitle;
    private String location;
    private String source;
    private Double salary;
    private Priority priority;
    private LocalDateTime appliedDate;
    private CurrentStatus currentStatus;
}
