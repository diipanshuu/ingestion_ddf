package com.ddf.ingestion_ddf.service;

import com.ddf.ingestion_ddf.enums.IngestionRequestStatus;
import com.ddf.ingestion_ddf.enums.IngestionStatus;
import com.ddf.ingestion_ddf.enums.OrderByField;
import com.ddf.ingestion_ddf.enums.OrderDirection;
import com.ddf.ingestion_ddf.request.mappers.DecisionRequestDTO;
import com.ddf.ingestion_ddf.request.mappers.IngestionRequest;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestSummaryDTO;

public interface IngestionRequestDetailsService {
    IngestionRequestDetailsDTO createOrUpdateIngestionRequest(Long ingestionRequestId,IngestionRequest ingestionRequest, boolean submit);
    IngestionRequestDetailsDTO getIngestionRequestDetail(Long ingestionRequestId);
    IngestionRequestSummaryDTO searchIngestionRequests(boolean myApprovals, boolean mySubmissions, IngestionRequestStatus status, int page, int perPage, OrderByField orderBy, OrderDirection orderDirection);
    IngestionRequestDetailsDTO updateIngestionRequestStatus(Long ingestionRequestId, IngestionStatus newStatus, DecisionRequestDTO decisionRequestDTO);
}
