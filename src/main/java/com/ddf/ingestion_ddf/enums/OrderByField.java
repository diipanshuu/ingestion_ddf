package com.ddf.ingestion_ddf.enums;

/**
 * Enum representing fields by which ingestion requests can be ordered.
 */
public enum OrderByField {
    INGESTION_REQUEST_ID("ingestionRequestId"),
    DATASET_REQUIRED_FOR_REF("datasetDetails.datasetRequiredForRef"),
    REQUESTED_BY_NAME("requestedByName"),
    ANALYSIS_INIT_DT("datasetDetails.analysisInitDt"),
    ANALYSIS_END_DT("datasetDetails.analysisEndDt"),
    MODIFIED_DATE("modifiedDate"),
    DATASET_SME_NAME("datasetDetails.datasetRoleDetails.role"),
    REQUESTER_BY_EMAIL("requesterEmail"),
    ACTIVE_REQUEST_STATUS("requestStatusDetails.status.statusName");

    private final String fieldName;

    OrderByField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}