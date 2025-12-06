package org.example.jobapplicationtracker.controller.Request;

import lombok.Data;

@Data
public class CreateNoteRequest {
    private String content;
    private Long applicationId;
}
