package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dataset_user_usage_restriction")
public class DatasetUserUsageRestriction extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usageUserRestrictionId;

    @ManyToOne
    @JoinColumn(name = "dataset_id")
    @JsonIgnore
    private DatasetDetails datasetId;
    private String restrictionTypeRef;
    private String restrictionRef;
    private String reasonForOther;

}

