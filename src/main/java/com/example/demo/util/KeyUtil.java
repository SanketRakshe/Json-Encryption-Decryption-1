package com.example.demo.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyUtil {
 private static KeyPair keyPair;

 static {
     try {
         KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
         keyPairGenerator.initialize(2048);
         keyPair = keyPairGenerator.generateKeyPair();
     } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
     }
 }

 public static KeyPair getKeyPair() {
     return keyPair;
 }
}