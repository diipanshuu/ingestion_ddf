package com.ddf.ingestion_ddf.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Embeddable
@MappedSuperclass
public class BaseModel {
    @Column(name = "created_by", insertable = true, updatable = false)
    private String createdBy;
    @Column(name = "created_date", insertable = true, updatable = false)
    private Date createdDate;
    @Column(name = "modified_by", insertable = true, updatable = true)
    private String modifiedBy;
    @Column(name = "modified_date", insertable = true, updatable = true)
    private Date modifiedDate;
    @PrePersist
    protected void onCreate() {
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedDate = new Date();
    }
}
