package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.IngestionRequestDetailsController;
import com.ddf.ingestion_ddf.enums.IngestionRequestStatus;
import com.ddf.ingestion_ddf.enums.OrderByField;
import com.ddf.ingestion_ddf.enums.OrderDirection;
import com.ddf.ingestion_ddf.request.mappers.IngestionRequest;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestSummaryDTO;
import com.ddf.ingestion_ddf.service.IngestionRequestDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngestionRequestDetailsControllerImpl implements IngestionRequestDetailsController {

    private IngestionRequestDetailsService ingestionRequestDetailsService;

    public IngestionRequestDetailsControllerImpl(IngestionRequestDetailsService ingestionRequestDetailsService) {
        this.ingestionRequestDetailsService = ingestionRequestDetailsService;
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> createIngestionRequest(boolean submit,IngestionRequest requestDto) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.createOrUpdateIngestionRequest(null,requestDto, submit);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> getIngestionRequest(Long ingestionRequestId) {
        IngestionRequestDetailsDTO ingestionRequestDetail = ingestionRequestDetailsService.getIngestionRequestDetail(ingestionRequestId);
        if (ingestionRequestDetail != null) {
            return ResponseEntity.ok(ingestionRequestDetail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<IngestionRequestDetailsDTO> updateIngestionRequest(
            Long ingestionRequestId,
            boolean submit,
            IngestionRequest requestDto) {
        IngestionRequestDetailsDTO response = ingestionRequestDetailsService.createOrUpdateIngestionRequest(ingestionRequestId,requestDto, submit);
        return ResponseEntity.ok(response);
    }

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
