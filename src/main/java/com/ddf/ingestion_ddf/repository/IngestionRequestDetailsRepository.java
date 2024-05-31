package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.IngestionRequestDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngestionRequestDetailsRepository extends JpaRepository<IngestionRequestDetails, Long> {

    Page<IngestionRequestDetails> findByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlag(List<String> statusNames, Boolean ActiveFlag, Pageable pageable);
    int countByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlag(List<String> statusNames, Boolean ActiveFlag);

    //We can use below methods instead of above methods for the Logged-in User ID as it is My-Submission
//    Page<IngestionRequestDetails> findByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlagAndCreatedBy(List<String> statusNames, Byte ActiveFlag,String createdBy, Pageable pageable);
//    int countByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlagAndCreatedBy(List<String> statusNames,String createdBy, Byte ActiveFlag);



}
