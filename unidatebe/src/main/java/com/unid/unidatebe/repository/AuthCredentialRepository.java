package com.unid.unidatebe.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unid.unidatebe.entity.AuthCredential;

@Repository
public interface AuthCredentialRepository extends MongoRepository<AuthCredential, String> {
    //Trova per email cifrata (dovrai cifrare l'email prima della query)
    Optional<AuthCredential> findByEncryptedEmail(String encryptedEmail);
}
