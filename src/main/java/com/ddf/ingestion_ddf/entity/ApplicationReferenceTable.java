package com.ddf.ingestion_ddf.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "application_reference_table")
public class ApplicationReferenceTable extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referenceId;

    private String referenceData;
    private String referenceDataType;
    private String referenceGroupType;
    private Long referenceOrder;

}
