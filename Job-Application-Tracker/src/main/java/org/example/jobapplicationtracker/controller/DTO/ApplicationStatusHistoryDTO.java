package org.example.jobapplicationtracker.controller.DTO;

import lombok.Data;
import org.example.jobapplicationtracker.model.CurrentStatus;

import java.time.LocalDateTime;

@Data
public class ApplicationStatusHistoryDTO {
    private Long id;
    private CurrentStatus currentStatus;
    private LocalDateTime changedAt;
    private String note;
    private Long applicationId;
}
