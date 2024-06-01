package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.ValidationNotesController;
import com.ddf.ingestion_ddf.entity.IngestionRequestDetails;
import com.ddf.ingestion_ddf.repository.IngestionRequestDetailsRepository;
import com.ddf.ingestion_ddf.repository.ValidationNotesRepository;
import com.ddf.ingestion_ddf.request.mappers.ValidationNotesRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.ValidationNotesDTO;
import com.ddf.ingestion_ddf.service.ValidationNotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ValidationNotesControllerImpl implements ValidationNotesController {

    private ValidationNotesService validationNotesService;
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;
    private ValidationNotesRepository validationNotesRepository;

    public ValidationNotesControllerImpl(ValidationNotesService validationNotesService,
                                         IngestionRequestDetailsRepository ingestionRequestDetailsRepository,
                                         ValidationNotesRepository validationNotesRepository) {
        this.validationNotesService = validationNotesService;
        this.ingestionRequestDetailsRepository = ingestionRequestDetailsRepository;
        this.validationNotesRepository = validationNotesRepository;
    }

    @Override
    public ResponseEntity<ValidationNotesDTO> createNote(Long ingestionRequestId,
                                                      ValidationNotesRequestDTO note) {
        Optional<IngestionRequestDetails> ingestionRequestDetails = ingestionRequestDetailsRepository.findById(ingestionRequestId);
        if(ingestionRequestDetails.isPresent()) {
            ValidationNotesDTO createdNote = validationNotesService.createOrUpdateNote(ingestionRequestId, note,null);
            return ResponseEntity.ok(createdNote);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ValidationNotesDTO> updateNote(Long ingestionRequestId,
                                                         Long noteId,
                                                         ValidationNotesRequestDTO noteDetails) {

        if(ingestionRequestDetailsRepository.findById(ingestionRequestId).isPresent() &&
                noteId != null && validationNotesRepository.findById(noteId).isPresent()) {
                ValidationNotesDTO updatedNote = validationNotesService.createOrUpdateNote(ingestionRequestId, noteDetails, noteId);
                return ResponseEntity.ok(updatedNote);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteNote(Long ingestionRequestId,
                                           Long noteId) {
        if(ingestionRequestDetailsRepository.findById(ingestionRequestId).isPresent() &&
                noteId != null && validationNotesRepository.findById(noteId).isPresent()) {
            validationNotesService.deleteNote(ingestionRequestId,noteId);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}