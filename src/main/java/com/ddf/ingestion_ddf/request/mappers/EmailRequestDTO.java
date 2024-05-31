package com.ddf.ingestion_ddf.request.mappers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDTO {
    private String to;
    private String subject;
    private String body;
}
