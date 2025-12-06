package org.example.jobapplicationtracker.controller.Request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.jobapplicationtracker.model.CurrentStatus;
import org.example.jobapplicationtracker.model.Priority;

import java.time.LocalDateTime;

@Data
public class CreateApplicationRequest {
    private String jobTitle;
    private Long companyId;
    private Long userId;
    private String location;
    private String source;
    private Double salary;
    private Priority priority;
    private LocalDateTime appliedDate;
    private CurrentStatus currentStatus;
}
