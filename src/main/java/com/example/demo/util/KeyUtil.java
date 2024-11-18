package com.example.demo.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KeyUtil {
 private static KeyPair keyPair;

 static {
     try {
         KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
         keyPairGenerator.initialize(2048);
         keyPair = keyPairGenerator.generateKeyPair();
         
         String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()); 
         String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()); 
         
         System.out.println("Public Key: " + publicKey); 
         
         System.out.println("Private Key: " + privateKey);
         
     } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
     }
 }

 public static KeyPair getKeyPair() {
     return keyPair;
 }
}