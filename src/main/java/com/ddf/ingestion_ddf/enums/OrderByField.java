package com.ddf.ingestion_ddf.enums;

/**
 * Enum representing fields by which ingestion requests can be ordered.
 */
public enum OrderByField {
    ingestionRequestId("ingestionRequestId"),
    datasetRequiredForRef("datasetDetails.datasetRequiredForRef"),
    requestedByName("requestedByName"),
    analysisInitDt("datasetDetails.analysisInitDt"),
    analysisEndDt("datasetDetails.analysisEndDt"),
    modifiedDate("modifiedDate"),
    datasetSmeName("datasetDetails.datasetRoleDetails.role"),
    requesterByEmail("requesterEmail"),
    activeRequestStatus("requestStatusDetails.status.statusName");

    private final String fieldName;

    OrderByField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}