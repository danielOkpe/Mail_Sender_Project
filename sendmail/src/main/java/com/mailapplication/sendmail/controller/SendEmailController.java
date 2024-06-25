package com.mailapplication.sendmail.controller;

import com.mailapplication.sendmail.model.EmailRequest;
import com.mailapplication.sendmail.service.EmailVerificationService;
import com.mailapplication.sendmail.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class SendEmailController {

    @Autowired
    private SendEmailService sendEmailService;


    @GetMapping(value = "/sendEmail")
    public ResponseEntity sendMail() {
        // Ajoutez ici votre logique pour envoyer l'email
        sendEmailService.sendMail("dnlokpe1@gmail.com", "Default", "Ceci est le mail par défaut");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Default mail sent successfully!");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/sendEmail")
    public ResponseEntity sendEmail(@RequestBody EmailRequest emailRequest) {
        String email = emailRequest.getEmailAddress();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();
        EmailVerificationService emailVerificationService = new EmailVerificationService();
        if (emailVerificationService.emailExists(email)) {
            sendEmailService.sendMail(email, subject, body);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Mail sent successfully!");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(400).body("Invalid email syntax");
        }
    }
}
