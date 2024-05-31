package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_role_details")
public class DatasetRoleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetRoleDetailsId;
    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String role;
    private String email;
    private String mudid;
    private String name;

}

