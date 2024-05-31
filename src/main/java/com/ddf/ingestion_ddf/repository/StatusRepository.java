package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatusNameIgnoreCase(String statusName);
}
