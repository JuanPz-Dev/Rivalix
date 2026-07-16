package com.rivalix.backend.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rivalix.backend.dto.request.UserRequest;
import com.rivalix.backend.dto.response.UserResponse;
import com.rivalix.backend.entity.User;
import com.rivalix.backend.mapper.UserMapper;
import com.rivalix.backend.repository.UserRepository;
import com.rivalix.backend.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse userCreate(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User saved = userRepository.save(user); 
        return userMapper.toDTO(saved);
    }

    @Override
    public UserResponse login(UserRequest userRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public UserResponse getUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }
    
}