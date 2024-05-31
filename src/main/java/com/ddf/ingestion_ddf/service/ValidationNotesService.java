package com.ddf.ingestion_ddf.service;

import com.ddf.ingestion_ddf.request.mappers.ValidationNotesRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.ValidationNotesDTO;


public interface ValidationNotesService {
    ValidationNotesDTO createOrUpdateNote(Long ingestionRequestId, ValidationNotesRequestDTO note,Long noteId);
    void deleteNote(Long ingestionRequestId,Long noteId);
}