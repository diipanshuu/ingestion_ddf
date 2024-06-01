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


/**
 * Implementation of the ValidationNotesController interface.
 */
@RestController
public class ValidationNotesControllerImpl implements ValidationNotesController {

    private ValidationNotesService validationNotesService;
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;
    private ValidationNotesRepository validationNotesRepository;


    /**
     * Constructor to initialize the controller with required services and repositories.
     *
     * @param validationNotesService The service for managing validation notes.
     * @param ingestionRequestDetailsRepository The repository for accessing ingestion request details.
     * @param validationNotesRepository The repository for accessing validation notes.
     */
    public ValidationNotesControllerImpl(ValidationNotesService validationNotesService,
                                         IngestionRequestDetailsRepository ingestionRequestDetailsRepository,
                                         ValidationNotesRepository validationNotesRepository) {
        this.validationNotesService = validationNotesService;
        this.ingestionRequestDetailsRepository = ingestionRequestDetailsRepository;
        this.validationNotesRepository = validationNotesRepository;
    }

    /**
     * Creates a new validation note for a specific ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param note The DTO containing the details of the validation note.
     * @return A ResponseEntity containing the details of the created validation note.
     */
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

    /**
     * Updates an existing validation note for a specific ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param noteId The ID of the validation note to update.
     * @param noteDetails The DTO containing the updated details of the validation note.
     * @return A ResponseEntity containing the details of the updated validation note.
     */
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


    /**
     * Deletes an existing validation note for a specific ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param noteId The ID of the validation note to delete.
     * @return A ResponseEntity indicating the success or failure of the operation.
     */
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