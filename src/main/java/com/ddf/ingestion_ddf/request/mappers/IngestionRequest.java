package com.ddf.ingestion_ddf.request.mappers;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * Data transfer object (DTO) for ingestion requests.
 */
@Data
public class IngestionRequest {
    /** Name of the requester. */
    private String requesterName;

    /** MUDID of the requester. */
    private String requesterMudid;

    /** Email of the requester. */
    private String requesterEmail;

    /** Name of the dataset. */
    private String datasetName;

    /** Name of the datasetSME for Data SME Role. */
    private String datasetSmeName;

    /** MUDID of the datasetSME for Data SME Role. */
    private String datasetSmeMudid;

    /** Email of the datasetSME for Data SME Role. */
    private String datasetSmeEmail;

    /** Reason for the ingestion request. */
    private String requestRationaleReason;

    /** Origin source of the dataset. */
    private String datasetOriginSource;

    /** Current data location reference. */
    private String currentDataLocationRef;

    /** Path of the data location. */
    private String dataLocationPath;

    /** Flag indicating meteor space Domino usage. */
    private Boolean meteorSpaceDominoUsageFlag;

    /** Flag indicating IHD usage. */
    private Boolean ihdFlag;

    /** Reference for dataset requirement. */
    private String datasetRequiredForRef;

    /** Reference for estimated data volume. */
    private String estimatedDataVolumeRef;

    /** Refresh frequency of the data. */
    private String dataRefreshFrequency;

    /** Initial analysis date. */
    private Date analysisInitDt;

    /** End analysis date. */
    private Date analysisEndDt;

    /** Flag indicating DTA contract completion. */
    private Boolean dtaContractCompleteFlag;

    /** Expected completion date for DTA. */
    private Date dtaExpectedCompletionDate;

    /** List of data category references. */
    private List<String> dataCategoryRefs;

    /** Reference for dataset type. */
    private String datasetTypeRef;

    /** List of study IDs. */
    private List<String> studyIds;

    /** Name of the dataset owner for Data owner role. */
    private String datasetOwnerName;

    /** MUDID of the dataset owner for Data owner role. */
    private String datasetOwnerMudid;

    /** Email of the dataset owner for Data owner role. */
    private String datasetOwnerEmail;

    /** Name of the dataset steward for Data steward role. */
    private String datasetStewardName;

    /** MUDID of the dataset steward for Data steward role. */
    private String datasetStewardMudid;

    /** Email of the dataset steward for Data steward role. */
    private String datasetStewardEmail;

    /** Contract partner associated with the dataset. */
    private String contractPartner;

    /** Retention rules for the dataset. */
    private String retentionRules;

    /** Contract date for retention rules. */
    private Date retentionRulesContractDate;

    /** List of usage restrictions. */
    private List<String> usageRestrictions;

    /** List of user restrictions. */
    private List<String> userRestrictions;

    /** Reference for information classification type. */
    private String informationClassificationTypeRef;

    /** Reference for PII type. */
    private String piiTypeRef;

    /** List of therapy areas associated with the dataset. */
    private List<String> therapyAreas;

    /** List of techniques and assays used in the dataset. */
    private List<String> techniqueAndAssays;

    /** List of indications for the dataset. */
    private List<String> indications;

    /** Target ingestion start date. */
    private Date targetIngestionStartDate;

    /** Target ingestion end date. */
    private Date targetIngestionEndDate;

    /** Target path for ingestion. */
    private String targetPath;

    /** Reference for dataset type ingestion. */
    private String datasetTypeIngestionRef;

    /** List of guest users' emails. */
    private List<String> guestUsersEmail;

    /** List of whitelisted IP addresses. */
    private List<String> whitelistIpAddresses;

    /** Name of the external staging container. */
    private String externalStagingContainerName;

    /** Domain request ID. */
    private String domainRequestId;

    /** Location of the external data source. */
    private String externalDataSourceLocation;

    /** GSK access source location reference. */
    private String gskAccessSourceLocationRef;

    /** Name of the external source secret key. */
    private String externalSourceSecretKeyName;
}