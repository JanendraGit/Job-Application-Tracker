package org.example.jobapplicationtracker.controller.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttachmentDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private Long applicationId;
    private LocalDateTime uploadedAt;
}
