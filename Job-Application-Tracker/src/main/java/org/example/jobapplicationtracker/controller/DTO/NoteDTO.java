package org.example.jobapplicationtracker.controller.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteDTO {
    private Long id;
    private String content;
    private Long applicationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
