package com.example.demoProject.common;

import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class Utility {
    public String toBase64(String str) {
        String encodedString = Base64.getEncoder().encodeToString(str.getBytes());
        return encodedString;
    }

    public String base64ToString(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
