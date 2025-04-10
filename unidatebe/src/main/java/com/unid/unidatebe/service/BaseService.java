package com.unid.unidatebe.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.unid.unidatebe.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseService {
    
    @Autowired
    private UserRepository userRepository;


}
