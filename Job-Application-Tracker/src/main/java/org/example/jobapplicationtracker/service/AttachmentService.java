package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.controller.DTO.AttachmentDTO;
import org.example.jobapplicationtracker.controller.Request.CreateAttachmentRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateAttachmentRequest;

import java.util.List;

public interface AttachmentService {
    AttachmentDTO addAttachment(CreateAttachmentRequest createAttachmentRequest);
    void updateAttachment(Long id, UpdateAttachmentRequest updateAttachmentRequest);
    void deleteAttachment(Long id);
    AttachmentDTO getAttachmentById(Long id);
    List<AttachmentDTO> getAllAttachmentsByApplicationId(Long applicationId);
}
