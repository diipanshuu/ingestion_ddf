package com.ddf.ingestion_ddf.api;

import com.ddf.ingestion_ddf.enums.IngestionRequestStatus;
import com.ddf.ingestion_ddf.enums.OrderByField;
import com.ddf.ingestion_ddf.enums.OrderDirection;
import com.ddf.ingestion_ddf.request.mappers.IngestionRequest;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestSummaryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ingestion_requests")
@Tag(name = "Ingestion Request")
public interface IngestionRequestDetailsController {
    @PostMapping
    @Operation(summary = "Create a new Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> createIngestionRequest(
            @RequestParam(name = "submit", defaultValue = "false") boolean submit,
            @RequestBody IngestionRequest requestDto);

    @GetMapping("/{ingestion_request_id}")
    @Operation(summary = "Get Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> getIngestionRequest(@PathVariable("ingestion_request_id") Long ingestionRequestId);

    @PutMapping("/{ingestion_request_id}")
    @Operation(summary = "Update Ingestion Request")
    ResponseEntity<IngestionRequestDetailsDTO> updateIngestionRequest(
            @PathVariable("ingestion_request_id") Long ingestionRequestId,
            @RequestParam(name = "submit", defaultValue = "false") boolean submit,
            @RequestBody IngestionRequest requestDto);

    @GetMapping
    @Operation(summary = "Search Ingestion Requests")
    ResponseEntity<IngestionRequestSummaryDTO> searchIngestionRequests(
            @RequestParam(name = "my_approvals", defaultValue = "false") boolean myApprovals,
            @RequestParam(name = "my_submissions", defaultValue = "true") boolean mySubmissions,
            @RequestParam(name = "status", defaultValue = "All") IngestionRequestStatus status,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "per_page", defaultValue = "20") int perPage,
            @RequestParam(name = "order_by", defaultValue = "MODIFIED_DATE") OrderByField orderBy,
            @RequestParam(name = "order_direction", defaultValue = "DESC") OrderDirection orderDirection
    );
}
