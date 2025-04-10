package com.unid.unidatebe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.unid.api.UserApi;
import com.unid.model.UserRequest;
import com.unid.model.UserResponse;
import com.unid.unidatebe.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController implements UserApi {

    public static final String SUCCESS = "SUCCESS";

    @Autowired
    private UserServiceImpl userService;
    
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest){
        UserResponse response = userService.create(userRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //TODO - updateUser

    //TODO - DeleteUser

    //TODO - GetUserById

    //TODO - GetUserByPreferences

}
