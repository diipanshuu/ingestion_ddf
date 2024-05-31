package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_indication")
public class DatasetIndication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetIndicationId;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String indication;

}

