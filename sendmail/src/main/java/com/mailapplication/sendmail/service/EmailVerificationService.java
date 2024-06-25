package com.mailapplication.sendmail.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailVerificationService {

    // Expression régulière pour valider une adresse email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);


    public boolean emailExists(String email) {
        if (EMAIL_PATTERN.matcher(email).matches()) {
            return true;
        }else {
            return false;
        }
    }
}
