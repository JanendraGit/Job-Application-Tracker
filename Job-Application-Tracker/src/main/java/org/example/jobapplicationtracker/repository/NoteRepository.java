package org.example.jobapplicationtracker.repository;

import org.example.jobapplicationtracker.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByApplicationId(Long applicationId);
}
