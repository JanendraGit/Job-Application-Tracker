package org.example.jobapplicationtracker.service;

import org.example.jobapplicationtracker.controller.DTO.NoteDTO;
import org.example.jobapplicationtracker.controller.Request.CreateNoteRequest;
import org.example.jobapplicationtracker.controller.Request.UpdateNoteRequest;

import java.util.List;

public interface NoteService {
    NoteDTO addNote(CreateNoteRequest createNoteRequest);
    void updateNote(Long id, UpdateNoteRequest updateNoteRequest);
    void deleteNote(Long id);
    NoteDTO getNoteById(Long id);
    List<NoteDTO> getAllNotesByApplicationId(Long applicationId);
}
