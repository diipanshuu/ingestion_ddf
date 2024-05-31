package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.TechnicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalDetailsRepository extends JpaRepository<TechnicalDetails,Long> {
}
