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
        User user = userRepository.findByEmail(userRequest.getEmail())
        .orElseThrow(()-> new RuntimeException("Correo no registrado"));
        if (!passwordEncoder.matches(userRequest.getPassword() , user.getPassword())) {
            throw new RuntimeException("Contraseña incorresta");
        }
        return userMapper.toDTO(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserResponse updateUser(Long id,UserRequest userRequest) {
        User user = userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        user.setEmail(userRequest.getEmail());

        User update = userRepository.save(user);
        return userMapper.toDTO(update);
    }

    @Override
    public void deleteUser(Long id) {
       if (!userRepository.existsById(id)) {
        throw new RuntimeException("Usuario no encontrado");
       }
        userRepository.deleteById(id);
    }
    
}