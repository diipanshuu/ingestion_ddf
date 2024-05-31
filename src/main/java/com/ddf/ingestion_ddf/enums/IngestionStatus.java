package com.ddf.ingestion_ddf.enums;


/**
 * Enum representing different statuses of ingestion processes.
 */
public enum IngestionStatus {
    DRAFT("Draft"),
    TRIAGE_PENDING_APPROVAL("Triage Pending Approval"),
    APPROVED("Approved"),
    REJECTED("Rejected"),
    INGESTION_IN_PROGRESS("Ingestion In-Progress"),
    INGESTION_COMPLETED("Ingestion Completed"),
    INGESTION_FAILURE("Ingestion Failure");

    private final String displayName;

    IngestionStatus(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
