package com.unid.unidatebe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unid.unidatebe.entity.University;

public interface UserRepository extends MongoRepository<University, String> {
    
}
