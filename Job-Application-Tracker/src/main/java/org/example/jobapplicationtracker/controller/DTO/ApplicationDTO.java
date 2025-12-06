package org.example.jobapplicationtracker.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jobapplicationtracker.model.CurrentStatus;
import org.example.jobapplicationtracker.model.Priority;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    private Long id;
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
