package com.ddf.ingestion_ddf.response.mappers;

import lombok.Data;

import java.util.Date;

/**
 * Data transfer object (DTO) for validation notes.
 */
@Data
public class ValidationNotesDTO {
    /** Unique identifier for the notes. */
    private Long notesId;

    /** Notes content. */
    private String notes;

    /** User who created the notes. */
    private String createdBy;

    /** Date when the notes were created. */
    private Date createdDate;

    /** User who last modified the notes. */
    private String modifiedBy;

    /** Date when the notes were last modified. */
    private Date modifiedDate;
}
