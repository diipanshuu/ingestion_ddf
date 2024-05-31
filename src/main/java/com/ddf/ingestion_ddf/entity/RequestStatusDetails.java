package com.ddf.ingestion_ddf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "request_status_details")
public class RequestStatusDetails extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestStatusId;

    @ManyToOne
    @JoinColumn(name = "ingestion_request_id")
    @JsonIgnore
    private IngestionRequestDetails ingestionRequest;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    private String decisionByName;
    private String decisionByMudid;
    private String decisionByEmail;
    private Date decisionDate;
    private String decisionComments;
    private String rejectionReason;
    private Byte activeFlag;

}

