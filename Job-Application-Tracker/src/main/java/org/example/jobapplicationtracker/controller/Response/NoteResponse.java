package org.example.jobapplicationtracker.controller.Response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteResponse {
    private Long id;
    private String content;
    private Long applicationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
