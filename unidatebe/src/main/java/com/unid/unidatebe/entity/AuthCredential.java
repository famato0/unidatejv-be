package com.unid.unidatebe.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.unid.unidatebe.utility.AESUtil;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Document(collection = "auth_credentials")
@AllArgsConstructor
@NoArgsConstructor
public class AuthCredential {
    @Id
    private String id;
    
    private String encryptedEmail;
    private byte[] emailIv;
    
    private String passwordHash;
    private byte[] salt;
    
    // Metodo per generare IV
    private byte[] generateIv() {
        byte[] iv = new byte[16]; // 128 bit per AES
        new SecureRandom().nextBytes(iv);
        return iv;
    }
    
    // Metodo per generare salt
    private byte[] generateSalt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }
    
    public void encryptEmail(String email, String secretKey) {
        try {
            this.emailIv = generateIv();
            this.encryptedEmail = AESUtil.encrypt(email, secretKey, this.emailIv);
        } catch (Exception e) {
            throw new RuntimeException("Email encryption failed", e);
        }
    }
    
    public String decryptEmail(String secretKey) {
        try {
            return AESUtil.decrypt(this.encryptedEmail, secretKey, this.emailIv);
        } catch (Exception e) {
            throw new RuntimeException("Email decryption failed", e);
        }
    }
    
    public void setPassword(String password) {
        this.salt = generateSalt();
        this.passwordHash = hashPassword(password, this.salt);
    }
    
    public boolean verifyPassword(String password) {
        String testHash = hashPassword(password, this.salt);
        return this.passwordHash.equals(testHash);
    }
    
    private String hashPassword(String password, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Password hashing failed", e);
        }
    }
    
    // Getters
    public String getId() { return id; }
    public String getEncryptedEmail() { return encryptedEmail; }
    public byte[] getEmailIv() { return emailIv; }
    public String getPasswordHash() { return passwordHash; }
    public byte[] getSalt() { return salt; }
}