package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.IngestionRequestStatusController;
import com.ddf.ingestion_ddf.enums.IngestionStatus;
import com.ddf.ingestion_ddf.repository.IngestionRequestDetailsRepository;
import com.ddf.ingestion_ddf.request.mappers.DecisionRequestDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.service.IngestionRequestDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngestionRequestStatusControllerImpl implements IngestionRequestStatusController {

    private IngestionRequestDetailsService ingestionRequestDetailsService;
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;

    public IngestionRequestStatusControllerImpl(IngestionRequestDetailsService ingestionRequestDetailsService,
                                                IngestionRequestDetailsRepository ingestionRequestDetailsRepository) {
        this.ingestionRequestDetailsService = ingestionRequestDetailsService;
        this.ingestionRequestDetailsRepository = ingestionRequestDetailsRepository;
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> submitIngestionRequest(Long ingestionRequestId) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId, IngestionStatus.TRIAGE_PENDING_APPROVAL,null);
        return ResponseEntity.ok(response);
    }

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

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> rejectIngestionRequest(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.REJECTED,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> markIngestionInProgress(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.INGESTION_IN_PROGRESS,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> markIngestionComplete(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.INGESTION_COMPLETED,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> markIngestionFailure(
            Long ingestionRequestId,
            DecisionRequestDTO decisionRequestDTO) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.updateIngestionRequestStatus(ingestionRequestId,IngestionStatus.INGESTION_FAILURE,decisionRequestDTO);
        return ResponseEntity.ok(response);
    }
}
