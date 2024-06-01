package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.IngestionRequestDetailsController;
import com.ddf.ingestion_ddf.enums.IngestionRequestStatus;
import com.ddf.ingestion_ddf.enums.OrderByField;
import com.ddf.ingestion_ddf.enums.OrderDirection;
import com.ddf.ingestion_ddf.repository.IngestionRequestDetailsRepository;
import com.ddf.ingestion_ddf.request.mappers.IngestionRequest;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestSummaryDTO;
import com.ddf.ingestion_ddf.service.IngestionRequestDetailsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class IngestionRequestDetailsControllerImpl implements IngestionRequestDetailsController {

    private IngestionRequestDetailsService ingestionRequestDetailsService;
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;

    /**
     * Constructor to initialize the controller with required services.
     *
     * @param ingestionRequestDetailsService The service for managing ingestion request details.
     * @param ingestionRequestDetailsRepository The repository for accessing ingestion request details.
     */
    public IngestionRequestDetailsControllerImpl(IngestionRequestDetailsService ingestionRequestDetailsService, IngestionRequestDetailsRepository ingestionRequestDetailsRepository) {
        this.ingestionRequestDetailsService = ingestionRequestDetailsService;
        this.ingestionRequestDetailsRepository = ingestionRequestDetailsRepository;
    }


    /**
     * Creates a new ingestion request.
     *
     * @param submit Indicates whether the request should be submitted.
     * @param requestDto The DTO containing the details of the ingestion request.
     * @return A ResponseEntity containing the details of the created ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> createIngestionRequest(
            boolean submit,
            @Valid IngestionRequest requestDto) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.createOrUpdateIngestionRequest(null,requestDto, submit);
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves the details of an existing ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request to retrieve.
     * @return A ResponseEntity containing the details of the ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> getIngestionRequest(Long ingestionRequestId) {
        IngestionRequestDetailsDTO ingestionRequestDetail = ingestionRequestDetailsService.getIngestionRequestDetail(ingestionRequestId);
        if (ingestionRequestDetail != null) {
            return ResponseEntity.ok(ingestionRequestDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates an existing ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request to update.
     * @param submit Indicates whether the request should be submitted.
     * @param requestDto The DTO containing the updated details of the ingestion request.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> updateIngestionRequest(
            Long ingestionRequestId,
            boolean submit,
            IngestionRequest requestDto) {
        if(ingestionRequestId != null && ingestionRequestId !=0 && ingestionRequestDetailsRepository.findById(ingestionRequestId).isPresent()) {
            IngestionRequestDetailsDTO response = ingestionRequestDetailsService.createOrUpdateIngestionRequest(ingestionRequestId, requestDto, submit);
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Searches for ingestion requests based on specified criteria.
     *
     * @param myApprovals Indicates whether to include requests pending approval by the current user.
     * @param mySubmissions Indicates whether to include requests submitted by the current user.
     * @param status The status of the ingestion requests to retrieve.
     * @param page The page number for pagination.
     * @param perPage The number of results per page for pagination.
     * @param orderBy The field to order the results by.
     * @param orderDirection The direction of the ordering (ascending or descending).
     * @return A ResponseEntity containing a summary of the matching ingestion requests.
     */
    @Override
    public ResponseEntity<IngestionRequestSummaryDTO> searchIngestionRequests(
            boolean myApprovals,
            boolean mySubmissions,
            IngestionRequestStatus status,
            int page,
            int perPage,
            OrderByField orderBy,
            OrderDirection orderDirection
    ) {
        IngestionRequestSummaryDTO results = ingestionRequestDetailsService.searchIngestionRequests(
                myApprovals, mySubmissions, status, page, perPage, orderBy, orderDirection
        );
        return ResponseEntity.ok(results);
    }

}
