package com.ddf.ingestion_ddf.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "ingestion_request_details")
public class IngestionRequestDetails extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingestionRequestId;

    private String requesterName;
    private String requesterMudid;
    private String requesterEmail;
    private String requestRationaleReason;
    private String modifiedReason;
    private String requestedByName;
    private String requestedByMudid;
    private String requestedByEmail;

    @OneToOne(mappedBy = "ingestionRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private DatasetDetails datasetDetails;

    @OneToOne(mappedBy = "ingestionRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private TechnicalDetails technicalDetails;

    @OneToMany(mappedBy = "ingestionRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestStatusDetails> requestStatusDetails;

}
