package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.RequestStatusDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestStatusDetailsRepository extends JpaRepository<RequestStatusDetails,Long> {
}
