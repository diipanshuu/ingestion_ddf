package com.ddf.ingestion_ddf.request.mappers;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * Data transfer object (DTO) for ingestion requests.
 */
@Data
public class IngestionRequest {
    /** Name of the requester. */
    @NotBlank(message = "Requester name is required")
    private String requesterName;

    /** MUDID of the requester. */
    @NotBlank(message = "Requester MUDID is required")
    private String requesterMudid;

    /** Email of the requester. */
    @Email(message = "Requester email should be valid")
    @NotBlank(message = "Requester email is required")
    private String requesterEmail;

    /** Name of the dataset. */
    @NotBlank(message = "Dataset name is required")
    private String datasetName;

    /** Name of the datasetSME for Data SME Role. */
    @NotBlank(message = "Dataset SME name is required")
    private String datasetSmeName;

    /** MUDID of the datasetSME for Data SME Role. */
    @NotBlank(message = "Dataset SME MUDID is required")
    private String datasetSmeMudid;

    /** Email of the datasetSME for Data SME Role. */
    @Email(message = "Dataset SME email should be valid")
    @NotBlank(message = "Dataset SME email is required")
    private String datasetSmeEmail;

    /** Reason for the ingestion request. */
    @NotBlank(message = "Request rationale reason is required")
    private String requestRationaleReason;

    /** Origin source of the dataset. */
    @NotBlank(message = "Dataset origin source is required")
    private String datasetOriginSource;

    /** Current data location reference. */
    @NotBlank(message = "Current data location reference is required")
    private String currentDataLocationRef;

    /** Path of the data location. */
    @NotBlank(message = "Data location path is required")
    private String dataLocationPath;

    /** Flag indicating meteor space Domino usage. */
    @NotNull(message = "Meteor space Domino usage flag is required")
    private Boolean meteorSpaceDominoUsageFlag;

    /** Flag indicating IHD usage. */
    @NotNull(message = "IHD flag is required")
    private Boolean ihdFlag;

    /** Reference for dataset requirement. */
    @NotBlank(message = "Dataset required for reference is required")
    private String datasetRequiredForRef;

    /** Reference for estimated data volume. */
    @NotBlank(message = "Estimated data volume reference is required")
    private String estimatedDataVolumeRef;

    /** Refresh frequency of the data. */
    @NotBlank(message = "Data refresh frequency is required")
    private String dataRefreshFrequency;

    /** Initial analysis date. */
    @NotNull(message = "Analysis init date is required")
    private Date analysisInitDt;

    /** End analysis date. */
    @NotNull(message = "Analysis end date is required")
    private Date analysisEndDt;

    /** Flag indicating DTA contract completion. */
    @NotNull(message = "DTA contract complete flag is required")
    private Boolean dtaContractCompleteFlag;

    /** Expected completion date for DTA. */
    private Date dtaExpectedCompletionDate;

    /** List of data category references. */
    private List<String> dataCategoryRefs;

    /** Reference for dataset type. */
    @NotBlank(message = "Dataset type reference is required")
    private String datasetTypeRef;

    /** List of study IDs. */
    private List<String> studyIds;

    /** Name of the dataset owner for Data owner role. */
    @NotBlank(message = "Dataset owner name is required")
    private String datasetOwnerName;

    /** MUDID of the dataset owner for Data owner role. */
    @NotBlank(message = "Dataset owner MUDID is required")
    private String datasetOwnerMudid;

    /** Email of the dataset owner for Data owner role. */
    @Email(message = "Dataset owner email should be valid")
    @NotBlank(message = "Dataset owner email is required")
    private String datasetOwnerEmail;

    /** Name of the dataset steward for Data steward role. */
    @NotBlank(message = "Dataset steward name is required")
    private String datasetStewardName;

    /** MUDID of the dataset steward for Data steward role. */
    @NotBlank(message = "Dataset steward MUDID is required")
    private String datasetStewardMudid;

    /** Email of the dataset steward for Data steward role. */
    @Email(message = "Dataset steward email should be valid")
    @NotBlank(message = "Dataset steward email is required")
    private String datasetStewardEmail;

    /** Contract partner associated with the dataset. */
    @NotBlank(message = "Contract partner is required")
    private String contractPartner;

    /** Retention rules for the dataset. */
    @NotBlank(message = "Retention rules are required")
    private String retentionRules;

    /** Contract date for retention rules. */
    @NotNull(message = "Retention rules contract date is required")
    private Date retentionRulesContractDate;

    /** List of usage restrictions. */
    private List<String> usageRestrictions;

    /** List of user restrictions. */
    private List<String> userRestrictions;

    /** Reference for information classification type. */
    @NotBlank(message = "Information classification type reference is required")
    private String informationClassificationTypeRef;

    /** Reference for PII type. */
    @NotBlank(message = "PII type reference is required")
    private String piiTypeRef;

    /** List of therapy areas associated with the dataset. */
    private List<String> therapyAreas;

    /** List of techniques and assays used in the dataset. */
    private List<String> techniqueAndAssays;

    /** List of indications for the dataset. */
    private List<String> indications;

    /** Target ingestion start date. */
    @NotNull(message = "Target ingestion start date is required")
    private Date targetIngestionStartDate;

    /** Target ingestion end date. */
    @NotNull(message = "Target ingestion end date is required")
    private Date targetIngestionEndDate;

    /** Target path for ingestion. */
    @NotBlank(message = "Target path is required")
    private String targetPath;

    /** Reference for dataset type ingestion. */
    @NotBlank(message = "Dataset type ingestion reference is required")
    private String datasetTypeIngestionRef;

    /** List of guest users' emails. */
    private List<String> guestUsersEmail;

    /** List of whitelisted IP addresses. */
    private List<String> whitelistIpAddresses;

    /** Name of the external staging container. */
    @NotBlank(message = "External staging container name is required")
    private String externalStagingContainerName;

    /** Domain request ID. */
    @NotBlank(message = "Domain request ID is required")
    private String domainRequestId;

    /** Location of the external data source. */
    @NotBlank(message = "External data source location is required")
    private String externalDataSourceLocation;

    /** GSK access source location reference. */
    @NotBlank(message = "GSK access source location reference is required")
    private String gskAccessSourceLocationRef;

    /** Name of the external source secret key. */
    @NotBlank(message = "External source secret key name is required")
    private String externalSourceSecretKeyName;

    /** Reason for modification. */
    @NotBlank(message = "Modified reason is required")
    private String modifiedReason;
}