package org.example.jobapplicationtracker.controller.Request;

import lombok.Data;
import org.example.jobapplicationtracker.model.CurrentStatus;

@Data
public class CreateApplicationStatusHistoryRequest {
    private CurrentStatus currentStatus;
    private String note;
    private Long applicationId;
}
