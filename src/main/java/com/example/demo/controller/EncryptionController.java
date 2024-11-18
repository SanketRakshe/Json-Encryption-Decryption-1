package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EncryptionService;

import java.util.Base64;

@RestController
@RequestMapping("/api")
public class EncryptionController {

 @Autowired
 private EncryptionService encryptionService;

 @PostMapping("/encrypt")
 public ResponseEntity<String> encrypt(@RequestBody String jsonData) {
     try {
         byte[] encryptedData = encryptionService.encrypt(jsonData);
         String encodedData = Base64.getEncoder().encodeToString(encryptedData);
         return ResponseEntity.ok(encodedData);
     } catch (Exception e) {
         return ResponseEntity.status(500).body("Encryption error: " + e.getMessage());
     }
 }

 @PostMapping("/decrypt")
 public ResponseEntity<String> decrypt(@RequestBody String encryptedData) {
     try {
         byte[] decodedData = Base64.getDecoder().decode(encryptedData);
         String decryptedData = encryptionService.decrypt(decodedData);
         return ResponseEntity.ok(decryptedData);
     } catch (Exception e) {
         return ResponseEntity.status(500).body("Decryption error: " + e.getMessage());
     }
 }
}