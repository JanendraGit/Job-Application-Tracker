package org.example.jobapplicationtracker.controller.Request;

import lombok.Data;

@Data
public class CreateAttachmentRequest {
    private String fileName;
    private String fileType;
    private Long applicationId;
}
