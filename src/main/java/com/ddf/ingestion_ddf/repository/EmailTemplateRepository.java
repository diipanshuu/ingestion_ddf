package com.ddf.ingestion_ddf.repository;

import com.ddf.ingestion_ddf.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
//    @Override
//    EmailTemplate save(EmailTemplate entity);
}

