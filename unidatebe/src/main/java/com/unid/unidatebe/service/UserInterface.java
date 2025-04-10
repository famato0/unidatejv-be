package com.unid.unidatebe.service;

import com.unid.model.UserRequest;
import com.unid.model.UserResponse;

public interface UserInterface {

    UserResponse create(UserRequest request);
}
