package org.example.jobapplicationtracker.controller.Request;

import lombok.Data;

@Data
public class UpdateAttachmentRequest {
    private String fileName;
    private String fileType;
}
