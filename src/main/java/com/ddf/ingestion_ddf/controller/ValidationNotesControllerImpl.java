package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.ValidationNotesController;
import com.ddf.ingestion_ddf.request.mappers.ValidationNotesRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.ValidationNotesDTO;
import com.ddf.ingestion_ddf.service.ValidationNotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationNotesControllerImpl implements ValidationNotesController {

    private ValidationNotesService validationNotesService;

    public ValidationNotesControllerImpl(ValidationNotesService validationNotesService) {
        this.validationNotesService = validationNotesService;
    }

    @Override
    public ResponseEntity<ValidationNotesDTO> createNote(Long ingestionRequestId,
                                                      ValidationNotesRequestDTO note) {
        ValidationNotesDTO createdNote = validationNotesService.createOrUpdateNote(ingestionRequestId, note,null);
        return ResponseEntity.ok(createdNote);
    }

    @Override
    public ResponseEntity<ValidationNotesDTO> updateNote(Long ingestionRequestId,
                                                         Long noteId,
                                                         ValidationNotesRequestDTO noteDetails) {
        ValidationNotesDTO updatedNote = validationNotesService.createOrUpdateNote(ingestionRequestId, noteDetails, noteId);
        return ResponseEntity.ok(updatedNote);
    }

    @Override
    public ResponseEntity<Void> deleteNote(Long ingestionRequestId,
                                           Long noteId) {
        validationNotesService.deleteNote(ingestionRequestId,noteId);
        return ResponseEntity.noContent().build();
    }
}