package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_tech_and_assay")
public class DatasetTechAndAssay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetTechAndAssayId;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String techniqueAndAssay;

}

