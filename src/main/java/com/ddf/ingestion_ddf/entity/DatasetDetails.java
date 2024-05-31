package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "dataset_details")
public class DatasetDetails extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datasetId;

    @OneToOne
    @JoinColumn(name = "ingestion_request_id")
    @JsonIgnore
    private IngestionRequestDetails ingestionRequest;

    private String datasetName;
    private String datasetOriginSource;
    private String currentDataLocationRef;
    private Boolean meteorSpaceDominoUsageFlag;
    private Boolean ihdFlag;
    private String datasetRequiredForRef;
    private String estimatedDataVolumeRef;
    private Date analysisInitDt;
    private Date analysisEndDt;
    private Boolean dtaContractCompleteFlag;
    private Date dtaExpectedCompletionDate;
    private String datasetTypeRef;
    private String informationClassificationTypeRef;
    private String piiTypeRef;
    private String retentionRules;
    private Date retentionRulesContractDate;
    private String contractPartner;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetUserUsageRestriction> datasetUserUsageRestriction;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetDataCategory> datasetDataCategories;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetStudy> datasetStudies;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetTherapy> datasetTherapies;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetTechAndAssay> datasetTechAndAssays;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetIndication> datasetIndications;

    @OneToMany(mappedBy = "datasetId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetRoleDetails> datasetRoleDetails;
}

