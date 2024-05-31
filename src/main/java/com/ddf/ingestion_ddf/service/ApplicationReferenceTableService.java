package com.ddf.ingestion_ddf.service;

import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;

import java.util.List;

public interface ApplicationReferenceTableService {
    List<ApplicationReferenceTableDTO> getAllReferences();
}

