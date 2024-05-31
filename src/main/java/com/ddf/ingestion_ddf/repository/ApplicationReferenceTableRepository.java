package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.ApplicationReferenceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ApplicationReferenceTableRepository extends JpaRepository<ApplicationReferenceTable, Long> {
}
