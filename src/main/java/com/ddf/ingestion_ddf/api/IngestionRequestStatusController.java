package com.ddf.ingestion_ddf.api;

import com.ddf.ingestion_ddf.request.mappers.DecisionRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ingestion_requests")
@Tag(name = "Ingestion Request Status")
public interface IngestionRequestStatusController {

    @PutMapping("/{ingestion_request_id}/submit")
    @Operation(summary = "Submit Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> submitIngestionRequest(@PathVariable("ingestion_request_id") Long ingestionRequestId);

    @PutMapping("/{ingestion_request_id}/approve")
    @Operation(summary = "Approve Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> approveIngestionRequest(
            @PathVariable("ingestion_request_id") Long ingestionRequestId,
            @RequestBody DecisionRequestDTO decisionRequestDTO);

    @PutMapping("/{ingestion_request_id}/reject")
    @Operation(summary = "Reject Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> rejectIngestionRequest(
            @PathVariable("ingestion_request_id") Long ingestionRequestId,
            @RequestBody DecisionRequestDTO decisionRequestDTO);

    @PutMapping("/{ingestion_request_id}/ingestion_in_progress")
    @Operation(summary = "In-Progress Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> markIngestionInProgress(
            @PathVariable("ingestion_request_id") Long ingestionRequestId,
            @RequestBody DecisionRequestDTO decisionRequestDTO);

    @PutMapping("/{ingestion_request_id}/ingestion_complete")
    @Operation(summary = "Complete Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> markIngestionComplete(
            @PathVariable("ingestion_request_id") Long ingestionRequestId,
            @RequestBody DecisionRequestDTO decisionRequestDTO);

    @PutMapping("/{ingestion_request_id}/ingestion_failure")
    @Operation(summary = "Failure Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> markIngestionFailure(
            @PathVariable("ingestion_request_id") Long ingestionRequestId,
            @RequestBody DecisionRequestDTO decisionRequestDTO);

}
