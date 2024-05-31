package com.ddf.ingestion_ddf.api;

import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "Application Reference")
public interface ApplicationReferenceTableController {
    @GetMapping("/application_references")
    @Operation(summary = "Get all reference data")
    ResponseEntity<List<ApplicationReferenceTableDTO>> getAllReferences();
}
