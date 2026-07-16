package com.rivalix.backend.service;

import com.rivalix.backend.dto.request.UserRequest;
import com.rivalix.backend.dto.response.UserResponse;

public interface IUserService {
    UserResponse userCreate (UserRequest userRequest);
    UserResponse login (UserRequest userRequest);
    UserResponse getUserById(Long id);
}