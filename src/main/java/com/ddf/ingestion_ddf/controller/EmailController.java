package com.ddf.ingestion_ddf.controller;

import com.ddf.ingestion_ddf.request.mappers.EmailRequestDTO;
import com.ddf.ingestion_ddf.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailRequestDTO emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return "Email sent!";
    }
}

