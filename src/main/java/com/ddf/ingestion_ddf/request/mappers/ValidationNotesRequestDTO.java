package com.ddf.ingestion_ddf.request.mappers;

import lombok.Data;

/**
 * Data transfer object (DTO) for validation notes requests.
 */
@Data
public class ValidationNotesRequestDTO {
    /** Validation notes for Ingestion Request. */
    private String notes;
}
