package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.IngestionRequestDetails;
import com.ddf.ingestion_ddf.entity.ValidationNotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationNotesRepository extends JpaRepository<ValidationNotes,Long> {
    List<ValidationNotes> findByIngestionRequest(IngestionRequestDetails ingestionRequestDetails);
}
