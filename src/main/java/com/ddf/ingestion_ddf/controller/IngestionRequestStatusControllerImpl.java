package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.IngestionRequestStatusController;
import com.ddf.ingestion_ddf.enums.IngestionStatus;
import com.ddf.ingestion_ddf.repository.IngestionRequestDetailsRepository;
import com.ddf.ingestion_ddf.request.mappers.DecisionRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.service.IngestionRequestDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Implementation of the IngestionRequestStatusController interface.
 */
@RestController
public class IngestionRequestStatusControllerImpl implements IngestionRequestStatusController {

    private IngestionRequestDetailsService ingestionRequestDetailsService;
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;

    /**
     * Constructor to initialize the controller with required services and repositories.
     *
     * @param ingestionRequestDetailsService The service for managing ingestion request details.
     * @param ingestionRequestDetailsRepository The repository for accessing ingestion request details.
     */
    public IngestionRequestStatusControllerImpl(IngestionRequestDetailsService ingestionRequestDetailsService,
                                                IngestionRequestDetailsRepository ingestionRequestDetailsRepository) {
        this.ingestionRequestDetailsService = ingestionRequestDetailsService;
        this.ingestionRequestDetailsRepository = ingestionRequestDetailsRepository;
    }

    /**
     * Submits an ingestion request for processing.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> submitIngestionRequest(Long ingestionRequestId) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId, IngestionStatus.TRIAGE_PENDING_APPROVAL,null);
        return ResponseEntity.ok(response);
    }

    /**
     * Approves an ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param decisionRequestDTO The decision details.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> approveIngestionRequest(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        if(ingestionRequestId != null && ingestionRequestId !=0 && ingestionRequestDetailsRepository.findById(ingestionRequestId).isPresent()){
            IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.APPROVED,decisionRequestDTO);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Rejects an ingestion request.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param decisionRequestDTO The decision details.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> rejectIngestionRequest(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.REJECTED,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }

    /**
     * Marks an ingestion request as in progress.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param decisionRequestDTO The decision details.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> markIngestionInProgress(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.INGESTION_IN_PROGRESS,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }

    /**
     * Marks an ingestion request as completed.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param decisionRequestDTO The decision details.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> markIngestionComplete(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.INGESTION_COMPLETED,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }

    /**
     * Marks an ingestion request as failed.
     *
     * @param ingestionRequestId The ID of the ingestion request.
     * @param decisionRequestDTO The decision details.
     * @return A ResponseEntity containing the details of the updated ingestion request.
     */
    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> markIngestionFailure(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.INGESTION_FAILURE,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }
}
