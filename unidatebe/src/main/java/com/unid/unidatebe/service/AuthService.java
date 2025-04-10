package com.unid.unidatebe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unid.unidatebe.entity.AuthCredential;
import com.unid.unidatebe.repository.AuthCredentialRepository;
import com.unid.unidatebe.utility.AESUtil;

@Service
public class AuthService {
    private final AuthCredentialRepository authRepo;
    private final String encryptionKey;
    
    public AuthService(AuthCredentialRepository authRepo,@Value("${app.encryption.key}") String encryptionKey) {
        this.authRepo = authRepo;
        this.encryptionKey = encryptionKey;
        
        if(encryptionKey.length() != 32) {
            throw new IllegalArgumentException("Encryption key must be exactly 32 characters long");
        }
    }
    
    @Transactional
    public void registerUser(String email, String password) throws Exception {
        if(authRepo.findByEncryptedEmail(
           AESUtil.encrypt(email, encryptionKey, new byte[16])).isPresent()) {
            throw new IllegalStateException("Email already registered");
        }
        
        AuthCredential credential = new AuthCredential();
        credential.encryptEmail(email, encryptionKey);
        credential.setPassword(password);
        authRepo.save(credential);
    }
    
    public boolean authenticate(String email, String password) throws Exception {
        // Crea un IV temporaneo solo per la query
        byte[] tempIv = new byte[16];
        String tempEncrypted = AESUtil.encrypt(email, encryptionKey, tempIv);
        
        AuthCredential credential = authRepo.findByEncryptedEmail(tempEncrypted)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        return credential.verifyPassword(password);
    }
}