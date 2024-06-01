package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.api.ApplicationReferenceTableController;
import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;
import com.ddf.ingestion_ddf.service.ApplicationReferenceTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implementation of the ApplicationReferenceTableController interface.
 * Handles HTTP requests related to application reference tables.
 */
@RestController
public class ApplicationReferenceTableControllerImpl implements ApplicationReferenceTableController {

    private ApplicationReferenceTableService referenceTableService;

    /**
     * Constructor to initialize the controller with a reference to the service.
     *
     * @param referenceTableService The service for managing application reference tables.
     */
    public ApplicationReferenceTableControllerImpl(ApplicationReferenceTableService referenceTableService) {
        this.referenceTableService = referenceTableService;
    }

    /**
     * Retrieves all application reference tables.
     *
     * @return A ResponseEntity containing a list of ApplicationReferenceTableDTO objects if successful,
     *         HttpStatus.OK status code. Otherwise, returns an empty list with HttpStatus.NOT_FOUND status code.
     */
    @Override
    public ResponseEntity<List<ApplicationReferenceTableDTO>> getAllReferences() {
        List<ApplicationReferenceTableDTO> references = referenceTableService.getAllReferences();
        return new ResponseEntity<>(references, HttpStatus.OK);
    }

}