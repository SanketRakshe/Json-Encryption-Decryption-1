package com.example.demo.service;

import com.example.demo.utils.RSAUtil;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private final RSAUtil rsaUtil;

    public EncryptionService(RSAUtil rsaUtil) {
        this.rsaUtil = rsaUtil;
    }

    public String encryptData(String jsonData) throws Exception {
        return rsaUtil.encrypt(jsonData);
    }

    public String decryptData(String encryptedData) throws Exception {
        return rsaUtil.decrypt(encryptedData);
    }
}
