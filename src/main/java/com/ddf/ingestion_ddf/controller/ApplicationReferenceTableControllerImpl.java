package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.ApplicationReferenceTableController;
import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;
import com.ddf.ingestion_ddf.service.ApplicationReferenceTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationReferenceTableControllerImpl implements ApplicationReferenceTableController {

    private ApplicationReferenceTableService referenceTableService;

    public ApplicationReferenceTableControllerImpl(ApplicationReferenceTableService referenceTableService) {
        this.referenceTableService = referenceTableService;
    }

    @Override
    public ResponseEntity<List<ApplicationReferenceTableDTO>> getAllReferences() {
        List<ApplicationReferenceTableDTO> references = referenceTableService.getAllReferences();
        return new ResponseEntity<>(references, HttpStatus.OK);
    }

}