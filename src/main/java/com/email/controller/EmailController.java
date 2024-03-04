package com.email.controller;

import com.email.model.EmailRequest;
import com.email.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class EmailController {

    private EmailService emailService;

    @PostMapping("sendemail")
    public ResponseEntity<?> sendMail(@RequestBody EmailRequest emailRequest){
        boolean result = emailService.sendEmail(emailRequest.getTo(),emailRequest.getSubject(),emailRequest.getMessage());
        if(result){
            return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully.........");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent......");
        }
    }

}
