package com.unid.unidatebe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unid.model.UserRequest;
import com.unid.model.UserResponse;
import com.unid.unidatebe.service.BaseService;
import com.unid.unidatebe.service.UserInterface;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl extends BaseService implements UserInterface{

    @Override
    @Transactional
    public UserResponse create(UserRequest request) {
        //TODO - Check Request 
        //TODO - logic
        //TODO - persist tramite metodo in baseService
        
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}
