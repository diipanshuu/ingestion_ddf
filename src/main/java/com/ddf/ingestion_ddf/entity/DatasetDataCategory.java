package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_data_category")
public class DatasetDataCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetDataCategoryId;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String dataCategoryRef;

}
