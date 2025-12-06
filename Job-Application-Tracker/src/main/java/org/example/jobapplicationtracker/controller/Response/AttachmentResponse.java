package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttachmentResponse {
    private Long id;
    private String fileName;
    private String fileType;
    private Long applicationId;
    private LocalDateTime uploadedAt;
}
