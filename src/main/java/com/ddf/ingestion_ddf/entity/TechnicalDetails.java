package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "technical_details")
public class TechnicalDetails extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technicalRequestId;

    @OneToOne
    @JoinColumn(name = "ingestion_request_id")
    @JsonIgnore
    private IngestionRequestDetails ingestionRequest;

    private String dataLocationPath;
    private String dataRefreshFrequency;
    private Date targetIngestionStartDate;
    private Date targetIngestionEndDate;
    private String targetPath;
    private String datasetTypeIngestionRef;
    private String guestUsersEmail;
    private String whitelistIpAddresses;
    private String externalStagingContainerName;
    private String externalDataSourceLocation;
    private String gckAccessSourceLocationRef;
    private String externalSourceSecretKeyName;
    private String domainRequestId;
    private String existingDataLocationIdentified;

}

