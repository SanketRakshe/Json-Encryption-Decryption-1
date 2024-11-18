package com.example.demo.controller;

import com.example.demo.service.EncryptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/encryption")
public class EncryptionController {

    private final EncryptionService encryptionService;

    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestBody String jsonData) {
        try {
            String encryptedData = encryptionService.encryptData(jsonData);
            return ResponseEntity.ok(encryptedData);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Encryption failed: " + e.getMessage());
        }
    }

    @PostMapping("/decrypt")
    public ResponseEntity<String> decrypt(@RequestBody String encryptedData) {
        try {
            String decryptedData = encryptionService.decryptData(encryptedData);
            return ResponseEntity.ok(decryptedData);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Decryption failed: " + e.getMessage());
        }
    }
}
