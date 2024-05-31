package com.ddf.ingestion_ddf.request.mappers;

import lombok.Data;

/**
 * Data transfer object (DTO) for decision requests.
 */
@Data
public class DecisionRequestDTO {
    /** Comments associated with the decision. */
    private String decisionComments;
    /** Flag indicating whether to send email. */
    private Boolean notifyThroughEmail;
    /** Reason for rejection, if applicable. */
    private String rejectionReason;
    /** Identifier for existing data location, if identified. */
    private String existingDataLocationIdentified;
}
