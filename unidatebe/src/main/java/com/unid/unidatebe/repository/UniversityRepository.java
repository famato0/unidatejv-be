package com.unid.unidatebe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unid.unidatebe.entity.University;

@Repository
public interface UniversityRepository extends MongoRepository<University, String> {
    Optional<University> findByEmailDomain(String domain);
    Optional<University> findByAcronym(String acronym);
    List<University> findByCity(String city);
}
