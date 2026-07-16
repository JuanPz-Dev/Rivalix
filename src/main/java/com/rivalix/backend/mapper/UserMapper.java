package com.rivalix.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rivalix.backend.dto.request.UserRequest;
import com.rivalix.backend.dto.response.UserResponse;
import com.rivalix.backend.entity.User;

@Mapper(componentModel  = "spring")
public interface UserMapper {
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "rol" , ignore =  true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "arenaGamingList" , ignore = true)
    User toEntity(UserRequest userRequest);
    UserResponse toDTO(User user);
    List<UserResponse> toDTO(List<User>users);
}