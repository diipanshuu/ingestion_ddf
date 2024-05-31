package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_therapy")
public class DatasetTherapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetTherapyId;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String therapy;

}

