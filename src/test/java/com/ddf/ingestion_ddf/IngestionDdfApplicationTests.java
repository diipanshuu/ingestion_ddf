package com.ddf.ingestion_ddf;

import com.ddf.ingestion_ddf.entity.*;
import com.ddf.ingestion_ddf.enums.IngestionRequestStatus;
import com.ddf.ingestion_ddf.enums.IngestionStatus;
import com.ddf.ingestion_ddf.enums.OrderByField;
import com.ddf.ingestion_ddf.enums.OrderDirection;
import com.ddf.ingestion_ddf.repository.*;
import com.ddf.ingestion_ddf.request.mappers.DecisionRequestDTO;
import com.ddf.ingestion_ddf.request.mappers.IngestionRequest;
import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestDetailsDTO;
import com.ddf.ingestion_ddf.response.mappers.IngestionRequestSummaryDTO;
import com.ddf.ingestion_ddf.service.EmailService;
import com.ddf.ingestion_ddf.service.impl.ApplicationReferenceTableServiceImpl;
import com.ddf.ingestion_ddf.service.impl.IngestionRequestDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.apache.commons.lang.ArrayUtils.isEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

@ExtendWith(MockitoExtension.class)
class IngestionDdfApplicationTests {

    @Mock
    private ApplicationReferenceTableRepository referenceTableRepository;


    @InjectMocks
    private ApplicationReferenceTableServiceImpl referenceTableService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        referenceTableService = new ApplicationReferenceTableServiceImpl(referenceTableRepository);
    }

    @Test
    void testGetAllReferences() {
        ApplicationReferenceTable reference1 = new ApplicationReferenceTable();
        reference1.setReferenceId(1L);
        reference1.setReferenceData("Other");
        reference1.setReferenceOrder(5L);
        reference1.setReferenceDataType("usage_restrictions");

        ApplicationReferenceTable reference2 = new ApplicationReferenceTable();
        reference2.setReferenceId(2L);
        reference2.setReferenceData("Confidential");
        reference2.setReferenceOrder(1L);
        reference2.setReferenceDataType("information_classification_type");

        List<ApplicationReferenceTable> mockReferences = Arrays.asList(reference1, reference2);

        when(referenceTableRepository.findAll()).thenReturn(mockReferences);

        List<ApplicationReferenceTableDTO> result = referenceTableService.getAllReferences();

        assertEquals(2, result.size());
        assertEquals("Other", result.get(1).getReferenceData());
        assertEquals("usage_restrictions", result.get(1).getReferenceDataType());
        assertEquals("Confidential", result.get(0).getReferenceData());
        assertEquals("information_classification_type", result.get(0).getReferenceDataType());
    }

    // Trying gpt
    @Mock
    private IngestionRequestDetailsRepository ingestionRequestDetailsRepository;

    @Mock
    private StatusRepository statusRepository;

    @Mock
    private EmailService emailService;

    @Mock
    private EmailTemplateRepository emailTemplateRepository;

    @Mock
    private TechnicalDetailsRepository technicalDetailsRepository;

    @InjectMocks
    private IngestionRequestDetailsServiceImpl ingestionRequestService;

    // adding to anticipate error
    @Mock
    private DatasetDetails datasetDetails;
    @Mock
    private ValidationNotesRepository validationNotesRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateOrUpdateIngestionRequest_CreateOperation() {
        MockitoAnnotations.initMocks(this);

        // Mocked data
        Long ingestionRequestId = null;
        IngestionRequest ingestionRequest = new IngestionRequest();
        boolean submit = false;
        String createdBy = "test@gmail.com";
        String modifiedBy = "testModifiy@gmail.com";
        ingestionRequest.setDtaContractCompleteFlag(true);

        // Mocking behavior
        when(statusRepository.findByStatusNameIgnoreCase(anyString())).thenReturn(new Status());
        when(ingestionRequestDetailsRepository.save(any())).thenAnswer(invocation -> {
            IngestionRequestDetails arg = invocation.getArgument(0);
            arg.setCreatedBy(createdBy);
            arg.setModifiedBy(modifiedBy);
            arg.setCreatedDate(new Date());
            arg.setModifiedDate(new Date());
            return arg;
        });

        // Method invocation
        IngestionRequestDetailsDTO result = ingestionRequestService.createOrUpdateIngestionRequest(ingestionRequestId, ingestionRequest, submit);

        // Assertions
        assertEquals(createdBy, result.getCreatedBy());
        assertEquals(modifiedBy, result.getModifiedBy());
        isEquals(new Date(), result.getCreatedDate());
        isEquals(new Date(), result.getModifiedDate());
    }

    @Test
    public void testCreateOrUpdateIngestionRequest_UpdateOperation() {
        MockitoAnnotations.initMocks(this);

        // Mocked data
        Long ingestionRequestId = 1L;
        IngestionRequest ingestionRequest = new IngestionRequest();
        boolean submit = false;
        String modifiedBy = "testModifiy@gmail.com";


        //Setting all the values
        ingestionRequest.setRequesterName("John Doe");
        ingestionRequest.setRequesterMudid("JD12345");
        ingestionRequest.setRequesterEmail("john.doe@example.com");
        ingestionRequest.setDatasetName("Clinical Trial Data");
        ingestionRequest.setDatasetSmeName("Jane Smith");
        ingestionRequest.setDatasetSmeMudid("JS54321");
        ingestionRequest.setDatasetSmeEmail("john.doe@example.com");
        ingestionRequest.setMeteorSpaceDominoUsageFlag(true);
        ingestionRequest.setIhdFlag(false);
        ingestionRequest.setDtaContractCompleteFlag(true);


        // Mocking behavior
        when(statusRepository.findByStatusNameIgnoreCase(anyString())).thenReturn(new Status());
        when(ingestionRequestDetailsRepository.findById(anyLong())).thenReturn(Optional.of(new IngestionRequestDetails()));
        when(ingestionRequestDetailsRepository.save(any())).thenAnswer(invocation -> {
            IngestionRequestDetails arg = invocation.getArgument(0);
            arg.setModifiedBy(modifiedBy);
            arg.setModifiedDate(new Date());
            arg.setModifiedReason("Test modified reason");
            return arg;
        });

        // Method invocation
        IngestionRequestDetailsDTO result = ingestionRequestService.createOrUpdateIngestionRequest(ingestionRequestId, ingestionRequest, submit);

        // Assertions
        assertEquals(modifiedBy, result.getModifiedBy());
        isEquals(new Date(), result.getModifiedDate());
        assertEquals("Test modified reason", result.getModifiedReason());
    }

    @Test
    public void testGetIngestionRequestDetails_RequestExists() {
        Long ingestionRequestId = 1L;
        IngestionRequestDetails requestDetails = new IngestionRequestDetails();
        requestDetails.setRequesterName("John Doe");
        requestDetails.setRequesterMudid("JD12345");
        requestDetails.setRequesterEmail("john.doe@example.com");

        when(ingestionRequestDetailsRepository.findById(ingestionRequestId)).thenReturn(Optional.of(requestDetails));

        IngestionRequestDetailsDTO result = ingestionRequestService.getIngestionRequestDetail(ingestionRequestId);

        assertNotNull(result);

    }

    @Test
    public void testGetIngestionRequestDetails_RequestDoesNotExist() {
        Long ingestionRequestId = 450L;
        IngestionRequestDetails requestDetails = new IngestionRequestDetails();
        requestDetails.setRequesterName("John Doe");
        requestDetails.setRequesterMudid("JD12345");
        requestDetails.setRequesterEmail("john.doe@example.com");

        when(ingestionRequestDetailsRepository.findById(ingestionRequestId)).thenReturn(Optional.empty());

        IngestionRequestDetailsDTO result = ingestionRequestService.getIngestionRequestDetail(ingestionRequestId);

        assertNull(result);

    }

    @Test
    public void testUpdateIngestionRequestStatus_RequestExists() {
        Long ingestionRequestId = 11L;
        IngestionStatus ingestionStatus = IngestionStatus.APPROVED;
        DecisionRequestDTO decisionRequestDTO = new DecisionRequestDTO();
        decisionRequestDTO.setNotifyThroughEmail(true);
        decisionRequestDTO.setDecisionComments("Test decision comments");
        decisionRequestDTO.setRejectionReason("Test rejection reason");

        IngestionRequestDetails requestDetails = new IngestionRequestDetails();
        requestDetails.setRequesterName("John Doe");
        requestDetails.setRequesterMudid("JD12345");
        requestDetails.setRequesterEmail("john.doe@example.com");

        when(ingestionRequestDetailsRepository.findById(ingestionRequestId)).thenReturn(Optional.of(requestDetails));

        IngestionRequestDetailsDTO requestDetailsDTO = ingestionRequestService.updateIngestionRequestStatus(ingestionRequestId,
                ingestionStatus, decisionRequestDTO);

        assertNotNull(requestDetailsDTO);

        // Verifying that emailService.sendEmail()
        // was called with correct parameters

        //verify(emailService, times(2)).sendEmail(anyString(), anyString(), anyString());
        //verify(technicalDetailsRepository).save(any(TechnicalDetails.class));
    }

    @Test
    public void testUpdateIngestionRequestStatus_RequestDoesNotExists() {
        Long ingestionRequestId = 1111L;
        IngestionStatus ingestionStatus = IngestionStatus.APPROVED;
        DecisionRequestDTO decisionRequestDTO = new DecisionRequestDTO();
        decisionRequestDTO.setNotifyThroughEmail(true);
        decisionRequestDTO.setDecisionComments("Test decision comments");
        decisionRequestDTO.setRejectionReason("Test rejection reason");

        IngestionRequestDetails requestDetails = new IngestionRequestDetails();
        requestDetails.setRequesterName("John Doe");
        requestDetails.setRequesterMudid("JD12345");
        requestDetails.setRequesterEmail("john.doe@example.com");

        when(ingestionRequestDetailsRepository.findById(ingestionRequestId)).thenReturn(Optional.empty());

        IngestionRequestDetailsDTO requestDetailsDTO = ingestionRequestService.updateIngestionRequestStatus(ingestionRequestId,
                ingestionStatus, decisionRequestDTO);

        assertNull(requestDetailsDTO);
    }

    //GPT
    @Test
    void testSearchIngestionRequests_AllStatuses() {
        boolean myApprovals = false;
        boolean mySubmissions = true;
        IngestionRequestStatus status = IngestionRequestStatus.All;
        int page = 1;
        int perPage = 20;
        OrderByField orderBy = OrderByField.modifiedDate;
        OrderDirection orderDirection = OrderDirection.ASC;

        Sort sort = Sort.by(orderBy.getFieldName()).ascending();
        Pageable pageable = PageRequest.of(page - 1, perPage, sort);

        List<IngestionRequestDetails> requestDetailsList = Arrays.asList(new IngestionRequestDetails(), new IngestionRequestDetails());
        Page<IngestionRequestDetails> requestDetailsPage = new PageImpl<>(requestDetailsList, pageable, requestDetailsList.size());

        List<String> statusNames = Arrays.asList(
                IngestionStatus.TRIAGE_PENDING_APPROVAL.toString(),
                IngestionStatus.APPROVED.toString(),
                IngestionStatus.REJECTED.toString(),
                IngestionStatus.INGESTION_IN_PROGRESS.toString(),
                IngestionStatus.INGESTION_COMPLETED.toString(),
                IngestionStatus.INGESTION_FAILURE.toString()
        );

        doReturn(requestDetailsPage).when(ingestionRequestDetailsRepository).findByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlag(
                eq(statusNames), eq(true), eq(pageable));

        IngestionRequestSummaryDTO result = ingestionRequestService.searchIngestionRequests(
                myApprovals, mySubmissions, status, page, perPage, orderBy, orderDirection);

        assertNotNull(result);
        assertNotNull(result.getItems());
    }

    @Test
    void testSearchIngestionRequests_NoResults() {
        boolean myApprovals = false;
        boolean mySubmissions = true;
        IngestionRequestStatus status = IngestionRequestStatus.CompletedRequest;
        int page = 1;
        int perPage = 20;
        OrderByField orderBy = OrderByField.modifiedDate;
        OrderDirection orderDirection = OrderDirection.ASC;

        Sort sort = Sort.by(orderBy.getFieldName()).ascending();
        Pageable pageable = PageRequest.of(page - 1, perPage, sort);

        List<IngestionRequestDetails> requestDetailsList = Arrays.asList();
        Page<IngestionRequestDetails> requestDetailsPage = new PageImpl<>(requestDetailsList, pageable, requestDetailsList.size());

        List<String> statusNames = Arrays.asList(IngestionStatus.INGESTION_COMPLETED.toString());

        doReturn(requestDetailsPage).when(ingestionRequestDetailsRepository).findByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlag(
                eq(statusNames), eq(true), eq(pageable));

        IngestionRequestSummaryDTO result = ingestionRequestService.searchIngestionRequests(
                myApprovals, mySubmissions, status, page, perPage, orderBy, orderDirection);

        assertNotNull(result);
        assertNotNull(result.getItems());
    }

    @Test
    void testSearchIngestionRequests_MyApprovals() {
        boolean myApprovals = true;
        boolean mySubmissions = false;
        IngestionRequestStatus status = IngestionRequestStatus.All;
        int page = 1;
        int perPage = 20;
        OrderByField orderBy = OrderByField.modifiedDate;
        OrderDirection orderDirection = OrderDirection.ASC;

        Sort sort = Sort.by(orderBy.getFieldName()).ascending();
        Pageable pageable = PageRequest.of(page - 1, perPage, sort);

        List<IngestionRequestDetails> requestDetailsList = Arrays.asList(new IngestionRequestDetails(), new IngestionRequestDetails());
        Page<IngestionRequestDetails> requestDetailsPage = new PageImpl<>(requestDetailsList, pageable, requestDetailsList.size());

        List<String> statusNames = Arrays.asList(IngestionStatus.DRAFT.toString());

        doReturn(requestDetailsPage).when(ingestionRequestDetailsRepository).findByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlag(
                eq(statusNames), eq(true), eq(pageable));

        IngestionRequestSummaryDTO result = ingestionRequestService.searchIngestionRequests(
                myApprovals, mySubmissions, status, page, perPage, orderBy, orderDirection);

        assertNotNull(result);
        assertNotNull(result.getItems());
    }

    @Test
    void testSearchIngestionRequests_InvalidStatus() {
        boolean myApprovals = false;
        boolean mySubmissions = true;
        IngestionRequestStatus status = IngestionRequestStatus.Rejected;
        int page = 1;
        int perPage = 20;
        OrderByField orderBy = OrderByField.modifiedDate;
        OrderDirection orderDirection = OrderDirection.ASC;

        Sort sort = Sort.by(orderBy.getFieldName()).ascending();
        Pageable pageable = PageRequest.of(page - 1, perPage, sort);

        List<IngestionRequestDetails> requestDetailsList = Arrays.asList();
        Page<IngestionRequestDetails> requestDetailsPage = new PageImpl<>(requestDetailsList, pageable, requestDetailsList.size());

        List<String> statusNames = Arrays.asList(IngestionStatus.REJECTED.toString());

        doReturn(requestDetailsPage).when(ingestionRequestDetailsRepository).findByRequestStatusDetailsStatusStatusNameInAndRequestStatusDetailsActiveFlag(
                eq(statusNames), eq(true), eq(pageable));

        IngestionRequestSummaryDTO result = ingestionRequestService.searchIngestionRequests(
                myApprovals, mySubmissions, status, page, perPage, orderBy, orderDirection);

        assertNotNull(result);
        assertNotNull(result.getItems());
    }
}
