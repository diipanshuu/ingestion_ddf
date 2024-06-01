//package com.ddf.ingestion_ddf;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class IngestionDdfApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//}

import com.ddf.ingestion_ddf.constants.ApiConstants;
import com.ddf.ingestion_ddf.entity.ApplicationReferenceTable;
import com.ddf.ingestion_ddf.entity.IngestionRequestDetails;
import com.ddf.ingestion_ddf.entity.Status;
import com.ddf.ingestion_ddf.enums.IngestionStatus;
import com.ddf.ingestion_ddf.repository.*;
import com.ddf.ingestion_ddf.request.mappers.IngestionRequest;
import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.service.EmailService;
import com.ddf.ingestion_ddf.service.impl.ApplicationReferenceTableServiceImpl;
import com.ddf.ingestion_ddf.service.impl.IngestionRequestDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class IngestionDdfApplicationTests {

    @Mock
    private ApplicationReferenceTableRepository referenceTableRepository;


    @InjectMocks
    private ApplicationReferenceTableServiceImpl referenceTableService;

    @Mock
    private IngestionRequestDetailsRepository ingestionRequestRepository;

    @Mock
    private StatusRepository statusRepository;

    @Mock
    private ValidationNotesRepository validationNotesRepository;

    @Mock
    private RequestStatusDetailsRepository requestStatusRepository;

    @Mock
    private TechnicalDetailsRepository technicalDetailsRepository;

    @Mock
    private EmailService emailService;

    @Mock
    private EmailTemplateRepository emailTemplateRepository;

    @InjectMocks
    private IngestionRequestDetailsServiceImpl ingestionRequestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        referenceTableService = new ApplicationReferenceTableServiceImpl(referenceTableRepository);
    }

    @Test
    void testGetAllReferences() {
        // Mock data
        ApplicationReferenceTable reference1 = new ApplicationReferenceTable();
        reference1.setReferenceId(1L);
        reference1.setReferenceData("Reference 1");
        reference1.setReferenceOrder(1L);
        reference1.setReferenceDataType("type1");

        ApplicationReferenceTable reference2 = new ApplicationReferenceTable();
        reference2.setReferenceId(2L);
        reference2.setReferenceData("Reference 2");
        reference2.setReferenceOrder(2L);
        reference2.setReferenceDataType("type2");

        List<ApplicationReferenceTable> mockReferences = Arrays.asList(reference1, reference2);

        // Mock repository behavior
        when(referenceTableRepository.findAll()).thenReturn(mockReferences);

        // Call the service method
        List<ApplicationReferenceTableDTO> result = referenceTableService.getAllReferences();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Reference 1", result.get(0).getReferenceData());
        assertEquals("type1", result.get(0).getReferenceDataType());
        assertEquals("Reference 2", result.get(1).getReferenceData());
        assertEquals("type2", result.get(1).getReferenceDataType());
    }


    @BeforeEach
    void setUpIngestionRequestRepo() {
        ingestionRequestRepository = mock(IngestionRequestDetailsRepository.class);
        StatusRepository statusRepository = mock(StatusRepository.class);
        ValidationNotesRepository validationNotesRepository = mock(ValidationNotesRepository.class);
        RequestStatusDetailsRepository requestStatusDetailsRepository = mock(RequestStatusDetailsRepository.class);
        TechnicalDetailsRepository technicalDetailsRepository = mock(TechnicalDetailsRepository.class);
        EmailService emailService = mock(EmailService.class);
        EmailTemplateRepository emailTemplateRepository = mock(EmailTemplateRepository.class);

        ingestionRequestService = new IngestionRequestDetailsServiceImpl(ingestionRequestRepository, statusRepository,
                validationNotesRepository, requestStatusDetailsRepository, technicalDetailsRepository, emailService,
                emailTemplateRepository);
    }

    @Test
    void testCreateOrUpdateIngestionRequest() {
        // Mock data
        IngestionRequest ingestionRequest = new IngestionRequest();
        // Set ingestionRequest properties
        ingestionRequest.setIngestionRequestId(1L);
        ingestionRequest.setRequesterName("testName");
        ingestionRequest.setRequesterMudid("JD12345");
        ingestionRequest.setRequesterEmail("john.doe@example.com");
        ingestionRequest.setDatasetName("Clinical Trial Data");
        ingestionRequest.setDatasetSmeName("Jane Smith");
        ingestionRequest.setDatasetSmeMudid("JS54321");
        ingestionRequest.setDatasetSmeEmail("jane.smith@example.com");
        ingestionRequest.setRequestRationaleReason("For statistical analysis");
        ingestionRequest.setDatasetOriginSource("Internal Research");
        ingestionRequest.setCurrentDataLocationRef("Data Warehouse");
        ingestionRequest.setDataLocationPath("/data/warehouse/clinical_trials");
        ingestionRequest.setMeteorSpaceDominoUsageFlag(true);
        ingestionRequest.setIhdFlag(false);
        ingestionRequest.setDatasetRequiredForRef("Exploration");
        ingestionRequest.setEstimatedDataVolumeRef("500GB");
        ingestionRequest.setDataRefreshFrequency("Monthly");
        ingestionRequest.setDtaContractCompleteFlag(true);
        ingestionRequest.setDataCategoryRefs(Arrays.asList("Clinical", "Genomics"));
        ingestionRequest.setDatasetTypeRef("Clinical Trial Data");
        ingestionRequest.setStudyIds(Arrays.asList("ST123", "ST456"));
        ingestionRequest.setDatasetOwnerName("Alice Johnson");
        ingestionRequest.setDatasetOwnerMudid("AJ67890");
        ingestionRequest.setDatasetOwnerEmail("alice.johnson@example.com");
        ingestionRequest.setDatasetStewardName("Bob Williams");
        ingestionRequest.setDatasetStewardMudid("BW09876");
        ingestionRequest.setDatasetStewardEmail("bob.williams@example.com");
        ingestionRequest.setContractPartner("XYZ Pharmaceuticals");
        ingestionRequest.setRetentionRules("7 years");
        ingestionRequest.setUsageRestrictions(Arrays.asList("Internal Use Only", "Confidential"));
        ingestionRequest.setUserRestrictions(Arrays.asList("Role-Based Access", "Restricted Access"));
        ingestionRequest.setInformationClassificationTypeRef("Confidential");
        ingestionRequest.setPiiTypeRef("None");
        ingestionRequest.setTherapyAreas(Arrays.asList("Cardiology", "Neurology"));
        ingestionRequest.setTechniqueAndAssays(Arrays.asList("PCR", "ELISA"));
        ingestionRequest.setIndications(Arrays.asList("Hypertension", "Alzheimer's Disease"));
        ingestionRequest.setTargetPath("/data/ingestion/clinical_trials");
        ingestionRequest.setDatasetTypeIngestionRef("Batch");
        ingestionRequest.setGuestUsersEmail(Arrays.asList("guest1@example.com", "guest2@example.com"));
        ingestionRequest.setWhitelistIpAddresses(Arrays.asList("192.168.1.1", "192.168.1.2"));
        ingestionRequest.setExternalStagingContainerName("staging-container");
        ingestionRequest.setDomainRequestId("DR78901");
        ingestionRequest.setExternalDataSourceLocation("/external/source/location");
        ingestionRequest.setGskAccessSourceLocationRef("GSK Internal Server");
        ingestionRequest.setExternalSourceSecretKeyName("external-secret-key");
        ingestionRequest.setModifiedReason("Testing");

        ingestionRequest.setIngestionRequestId(1L);
        // Mock behavior for ingestionRequestRepository
        IngestionRequestDetails mockDetails = new IngestionRequestDetails();
        mockDetails.setCreatedBy(ApiConstants.DEFAULT_CREATED_BY);
        mockDetails.setModifiedBy(ApiConstants.DEFAULT_MODIFIED_BY);
        when(ingestionRequestRepository.findById(1L)).thenReturn(Optional.of(mockDetails));
        when(ingestionRequestRepository.findById(0L)).thenReturn(Optional.empty());
        when(ingestionRequestRepository.save(any(IngestionRequestDetails.class))).thenReturn(mockDetails);

        // Mock behavior for ingestionRequestRepository
        when(ingestionRequestRepository.findById(1L)).thenReturn(Optional.of(new IngestionRequestDetails()));
        when(ingestionRequestRepository.findById(0L)).thenReturn(Optional.empty());
        when(ingestionRequestRepository.save(any(IngestionRequestDetails.class))).thenReturn(new IngestionRequestDetails());

        // Mock behavior for statusRepository
        Status triagePendingApprovalStatus = new Status();
        triagePendingApprovalStatus.setStatusName(IngestionStatus.TRIAGE_PENDING_APPROVAL.toString());
        Status draftStatus = new Status();
        draftStatus.setStatusName(IngestionStatus.DRAFT.toString());
        when(statusRepository.findByStatusNameIgnoreCase(IngestionStatus.TRIAGE_PENDING_APPROVAL.toString())).thenReturn(triagePendingApprovalStatus);
        when(statusRepository.findByStatusNameIgnoreCase(IngestionStatus.DRAFT.toString())).thenReturn(draftStatus);

        // Call the method
        IngestionRequestDetailsDTO result1 = ingestionRequestService.createOrUpdateIngestionRequest(1L, ingestionRequest, false);
        // Assertions
//        assertNotNull(result1); // Check that result1 is not null
        assertEquals(ApiConstants.DEFAULT_CREATED_BY, result1.getCreatedBy());
        assertEquals(ApiConstants.DEFAULT_MODIFIED_BY, result1.getModifiedBy());
    }
}
