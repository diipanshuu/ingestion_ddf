package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_study")
public class DatasetStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetStudyId;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String studyId;

}

