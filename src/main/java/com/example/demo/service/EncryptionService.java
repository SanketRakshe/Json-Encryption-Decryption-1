package com.example.demo.service;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

import com.example.demo.util.KeyUtil;

@Service
public class EncryptionService {

 private PublicKey publicKey = KeyUtil.getKeyPair().getPublic();
 private PrivateKey privateKey = KeyUtil.getKeyPair().getPrivate();

 public byte[] encrypt(String data) throws Exception {
     Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
     cipher.init(Cipher.ENCRYPT_MODE, publicKey);
     return cipher.doFinal(data.getBytes("UTF-8"));
 }

 public String decrypt(byte[] data) throws Exception {
     Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
     cipher.init(Cipher.DECRYPT_MODE, privateKey);
     byte[] decryptedData = cipher.doFinal(data);
     return new String(decryptedData, "UTF-8");
 }
}