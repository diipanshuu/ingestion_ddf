package com.ddf.ingestion_ddf.base_ingestion_request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BaseIngestionRequest {

    private Long ingestionRequestId;

    // Requester details
    private String requesterName;
    @NotBlank(message = "Requester MUDID is required")
    private String requesterMudid;
    @Email(message = "Requester email should be valid")
    @NotBlank(message = "Requester email is required")
    private String requesterEmail;

    // Dataset details
    @NotBlank(message = "Dataset name is required")
    private String datasetName;
    @NotBlank(message = "Dataset SME name is required")
    private String datasetSmeName;
    @NotBlank(message = "Dataset SME MUDID is required")
    private String datasetSmeMudid;
    @Email(message = "Dataset SME email should be valid")
    @NotBlank(message = "Dataset SME email is required")
    private String datasetSmeEmail;
    @NotBlank(message = "Request rationale reason is required")
    private String requestRationaleReason;
    @NotBlank(message = "Dataset origin source is required")
    private String datasetOriginSource;
    @NotBlank(message = "Current data location reference is required")
    private String currentDataLocationRef;
    @NotBlank(message = "Data location path is required")
    private String dataLocationPath;

    // Access details
    @NotNull(message = "Meteor space Domino usage flag is required")
    private Boolean meteorSpaceDominoUsageFlag;
    @NotNull(message = "IHD flag is required")
    private Boolean ihdFlag;
    @NotBlank(message = "Dataset required for reference is required")
    private String datasetRequiredForRef;
    @NotBlank(message = "Estimated data volume reference is required")
    private String estimatedDataVolumeRef;
    @NotBlank(message = "Data refresh frequency is required")
    private String dataRefreshFrequency;

    // Analysis details
    @NotNull(message = "Analysis init date is required")
    private Date analysisInitDt;
    @NotNull(message = "Analysis end date is required")
    private Date analysisEndDt;
    @NotNull(message = "DTA contract complete flag is required")
    private Boolean dtaContractCompleteFlag;
    private Date dtaExpectedCompletionDate;

    // Dataset properties
    private List<String> dataCategoryRefs;
    @NotBlank(message = "Dataset type reference is required")
    private String datasetTypeRef;
    private List<String> studyIds;

    // Owner and steward details
    @NotBlank(message = "Dataset owner name is required")
    private String datasetOwnerName;
    @NotBlank(message = "Dataset owner MUDID is required")
    private String datasetOwnerMudid;
    @Email(message = "Dataset owner email should be valid")
    @NotBlank(message = "Dataset owner email is required")
    private String datasetOwnerEmail;
    @NotBlank(message = "Dataset steward name is required")
    private String datasetStewardName;
    @NotBlank(message = "Dataset steward MUDID is required")
    private String datasetStewardMudid;
    @Email(message = "Dataset steward email should be valid")
    @NotBlank(message = "Dataset steward email is required")
    private String datasetStewardEmail;

    // Contract details
    @NotBlank(message = "Contract partner is required")
    private String contractPartner;
    @NotBlank(message = "Retention rules are required")
    private String retentionRules;
    @NotNull(message = "Retention rules contract date is required")
    private Date retentionRulesContractDate;
    private List<String> usageRestrictions;
    private List<String> userRestrictions;

    // Classification details
    @NotBlank(message = "Information classification type reference is required")
    private String informationClassificationTypeRef;
    @NotBlank(message = "PII type reference is required")
    private String piiTypeRef;

    // Additional details
    private List<String> therapyAreas;
    private List<String> techniqueAndAssays;
    private List<String> indications;

    // Ingestion details
    @NotNull(message = "Target ingestion start date is required")
    private Date targetIngestionStartDate;
    @NotNull(message = "Target ingestion end date is required")
    private Date targetIngestionEndDate;
    @NotBlank(message = "Target path is required")
    private String targetPath;
    @NotBlank(message = "Dataset type ingestion reference is required")
    private String datasetTypeIngestionRef;
    private List<String> guestUsersEmail;
    private List<String> whitelistIpAddresses;
    @NotBlank(message = "External staging container name is required")
    private String externalStagingContainerName;
    @NotBlank(message = "Domain request ID is required")
    private String domainRequestId;
    @NotBlank(message = "External data source location is required")
    private String externalDataSourceLocation;
    @NotBlank(message = "GSK access source location reference is required")
    private String gskAccessSourceLocationRef;
    @NotBlank(message = "External source secret key name is required")
    private String externalSourceSecretKeyName;
    @NotBlank(message = "Modified reason is required")
    private String modifiedReason;
}
