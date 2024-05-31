package com.ddf.ingestion_ddf.service.impl;

import com.ddf.ingestion_ddf.entity.IngestionRequestDetails;
import com.ddf.ingestion_ddf.entity.ValidationNotes;
import com.ddf.ingestion_ddf.repository.IngestionRequestDetailsRepository;
import com.ddf.ingestion_ddf.repository.ValidationNotesRepository;
import com.ddf.ingestion_ddf.request.mappers.ValidationNotesRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.ValidationNotesDTO;
import com.ddf.ingestion_ddf.service.ValidationNotesService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the {@link ValidationNotesService} interface.
 * This service provides methods to handle ingestion request's validation notes details.
 * It interacts with various repositories to access and manipulate data.
 *
 * @author Brijesh Rajput
 * @version 1.0
 * @since 20/05/24
 */
@Service
public class ValidationNotesServiceImpl implements ValidationNotesService {

    private ValidationNotesRepository validationNotesRepository;
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;

    /**
     * Constructs a ValidationNotesServiceImpl with the given repositories.
     *
     * @param validationNotesRepository        The repository for validation notes.
     * @param ingestionRequestDetailsRepository The repository for ingestion request details.
     */
    public ValidationNotesServiceImpl(ValidationNotesRepository validationNotesRepository, IngestionRequestDetailsRepository ingestionRequestDetailsRepository) {
        this.validationNotesRepository = validationNotesRepository;
        this.ingestionRequestDetailsRepository = ingestionRequestDetailsRepository;
    }

    /**
     * Creates or updates a validation note for the specified ingestion request.
     *
     * @param ingestionRequestId      The ID of the ingestion request.
     * @param validationNotesRequestDTO The DTO containing the validation note details.
     * @param noteId                  The ID of the validation note, if updating an existing note.
     * @return The DTO representation of the created or updated validation note.
     */
    @Override
    public ValidationNotesDTO createOrUpdateNote(Long ingestionRequestId, ValidationNotesRequestDTO validationNotesRequestDTO,Long noteId) {
        // Retrieve the ingestion request details by ID
        Optional<IngestionRequestDetails> ingestionRequestDetails = ingestionRequestDetailsRepository.findById(ingestionRequestId);
        // Check if the ingestion request details are present
        if(ingestionRequestDetails.isPresent()){
            ValidationNotes notes;
            // As logged-in user details are not available, using static emails for createdBy and modifiedBy
            String createdBy = "testStatusCreated@gamil.com";  // Update with logged-in user email
            String modifyBy = "testStatusModify@gamil.com";  // Update with logged-in user email

            // Check if the note ID is provided and exists in the repository if exists then update operation needed
            if(noteId != null && validationNotesRepository.findById(noteId).isPresent()){
                notes = validationNotesRepository.findById(noteId).get();
                notes.setNotesId(noteId);
            }else{
                notes = new ValidationNotes();
                notes.setIngestionRequest(ingestionRequestDetails.get());
                notes.setCreatedBy(createdBy);
            }
            notes.setNotes(validationNotesRequestDTO.getNotes());
            notes.setModifiedBy(modifyBy);
            // Save the note and convert to DTO
            return convertToDto(validationNotesRepository.save(notes));
        }
        return null;
    }

    /**
     * Deletes the validation note with the specified ID for the given ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param noteId             The ID of the validation note to delete.
     */
    @Override
    public void deleteNote(Long ingestionRequestId,Long noteId) {
        // Check if both ingestion request and note exist, then delete the note
        Optional<IngestionRequestDetails> ingestionRequestDetails = ingestionRequestDetailsRepository.findById(ingestionRequestId);
        if(ingestionRequestDetails.isPresent() && validationNotesRepository.findById(noteId).isPresent()) {
            validationNotesRepository.deleteById(noteId);
        }
    }

    /**
     * Converts a ValidationNotes entity to its DTO representation.
     *
     * @param validationNotes The ValidationNotes entity to convert.
     * @return The DTO representation of the validation notes.
     */
    private ValidationNotesDTO convertToDto(ValidationNotes validationNotes) {
        ValidationNotesDTO dto = new ValidationNotesDTO();
        BeanUtils.copyProperties(validationNotes, dto);
        return dto;
    }
}
