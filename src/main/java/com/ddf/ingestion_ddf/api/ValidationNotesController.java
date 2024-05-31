package com.ddf.ingestion_ddf.api;

import com.ddf.ingestion_ddf.request.mappers.ValidationNotesRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.ValidationNotesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ingestion_requests")
@Tag(name = "Ingestion Request Note")
public interface ValidationNotesController {

    @PostMapping("/{ingestion_request_id}/notes")
    @Operation(summary = "Create a new Validation Note")
    ResponseEntity<ValidationNotesDTO> createNote(@PathVariable("ingestion_request_id")  Long ingestionRequestId,
                                                         @RequestBody ValidationNotesRequestDTO note);

    @PutMapping("/{ingestion_request_id}/notes/{note_id}")
    @Operation(summary = "Update a Validation Note")
    ResponseEntity<ValidationNotesDTO> updateNote(@PathVariable("ingestion_request_id")  Long ingestionRequestId,
                                                         @PathVariable("note_id")  Long noteId,
                                                         @RequestBody ValidationNotesRequestDTO noteDetails);

    @DeleteMapping("/{ingestion_request_id}/notes/{note_id}")
    @Operation(summary = "Delete a Validation Note")
    public ResponseEntity<Void> deleteNote(@PathVariable("ingestion_request_id")  Long ingestionRequestId,
                                           @PathVariable("note_id")  Long noteId);
}
