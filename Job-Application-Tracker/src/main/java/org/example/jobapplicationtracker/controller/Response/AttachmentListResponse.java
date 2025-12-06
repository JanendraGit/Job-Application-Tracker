package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.util.List;

@Data
public class AttachmentListResponse {
    private List<AttachmentResponse> attachments;
}
