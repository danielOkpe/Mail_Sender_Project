package com.MailSender.maislSender.controller;

import com.MailSender.maislSender.service.EmailVerificationService;
import com.MailSender.maislSender.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MailSender.maislSender.model.EmailRequest;


@RestController
@CrossOrigin
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;
    private EmailVerificationService emailVerificationService;


    @GetMapping(value = "/sendEmail")
    public ResponseEntity<String> sendMail() {
            // Ajoutez ici votre logique pour envoyer l'email
            sendEmailService.sendMail("dnlokpe1@gmail.com", "Default", "Ceci est le mail par défaut");
            return ResponseEntity.ok("Email sent successfully");
    }


    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        String email = emailRequest.getEmailAddress();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();
        emailVerificationService = new EmailVerificationService();
        if (emailVerificationService.emailExists(email)) {
            sendEmailService.sendMail(email, subject,body );
            return ResponseEntity.ok("Email sent successfully");
        }else {
            return ResponseEntity.status(400).body("Invalid email syntax");
        }

    }

}