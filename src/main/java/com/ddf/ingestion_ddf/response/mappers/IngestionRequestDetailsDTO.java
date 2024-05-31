package com.ddf.ingestion_ddf.response.mappers;

import com.ddf.ingestion_ddf.entity.ValidationNotes;
import com.ddf.ingestion_ddf.response.mappers.RequestStatusDetailsDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Data transfer object (DTO) for ingestion request details.
 */
@Data
public class IngestionRequestDetailsDTO {
    /** Ingestion request ID. */
    private Long ingestionRequestId;

    /** Name of the requester. */
    private String requesterName;

    /** Mud ID of the requester. */
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

    /** Reason for the request. */
    private String requestRationaleReason;

    /** Source of the dataset origin. */
    private String datasetOriginSource;

    /** Current data location reference. */
    private String currentDataLocationRef;

    /** Path of the data location. */
    private String dataLocationPath;

    /** Flag indicating MeteorSpace Domino usage. */
    private Boolean meteorSpaceDominoUsageFlag;

    /** Flag indicating IHD usage. */
    private Boolean ihdFlag;

    /** Reference for dataset requirement. */
    private String datasetRequiredForRef;

    /** Reference for estimated data volume. */
    private String estimatedDataVolumeRef;

    /** Refresh frequency of the data. */
    private String dataRefreshFrequency;

    /** Date of analysis initiation. */
    private Date analysisInitDt;

    /** Date of analysis completion. */
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

    /** Contract partner. */
    private String contractPartner;

    /** Retention rules. */
    private String retentionRules;

    /** Contract date for retention rules. */
    private Date retentionRulesContractDate;

    /** List of usage restrictions. */
    private List<String> usageRestrictions;

    /** List of user restrictions. */
    private List<String> userRestrictions;

    /** Information classification type reference. */
    private String informationClassificationTypeRef;

    /** PII type reference. */
    private String piiTypeRef;

    /** List of therapy areas. */
    private List<String> therapyAreas;

    /** List of techniques and assays. */
    private List<String> techniqueAndAssays;

    /** List of indications. */
    private List<String> indications;

    /** Target ingestion start date. */
    private Date targetIngestionStartDate;

    /** Target ingestion end date. */
    private Date targetIngestionEndDate;

    /** Target path for ingestion. */
    private String targetPath;

    /** Reference for dataset type ingestion. */
    private String datasetTypeIngestionRef;

    /** List of guest users' email addresses. */
    private List<String> guestUsersEmail;

    /** List of whitelist IP addresses. */
    private List<String> whitelistIpAddresses;

    /** Name of the external staging container. */
    private String externalStagingContainerName;

    /** Domain request ID. */
    private String domainRequestId;

    /** External data source location. */
    private String externalDataSourceLocation;

    /** GSK access source location reference. */
    private String gskAccessSourceLocationRef;

    /** External source secret key name. */
    private String externalSourceSecretKeyName;

    /** Reason for modification. */
    private String modifiedReason;

    /** Active request status. */
    private RequestStatusDetailsDTO activeRequestStatus;

    /** Flag indicating if existing data location is identified. */
    private String existingDataLocationIdentified;

    /** List of validation notes. */
    private List<ValidationNotes> notes;

    /** User who created the request. */
    private String createdBy;

    /** Date of creation. */
    private Date createdDate;

    /** User who modified the request. */
    private String modifiedBy;

    /** Date of modification. */
    private Date modifiedDate;
}