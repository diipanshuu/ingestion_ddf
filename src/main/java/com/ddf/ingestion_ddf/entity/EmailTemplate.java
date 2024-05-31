package com.ddf.ingestion_ddf.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "email_template")
public class EmailTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;

    private String templateCode;
    private String subject;
    private String body;

}

