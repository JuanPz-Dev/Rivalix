package com.rivalix.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rivalix.backend.dto.request.ArenaGamingRequest;
import com.rivalix.backend.dto.response.ArenaGamingResponse;
import com.rivalix.backend.entity.ArenaGaming;

@Mapper(componentModel = "spring")
public interface ArenaGamingMapper {
    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "createdAt" , ignore = true)
    @Mapping(target = "user" , ignore = true)
    @Mapping(target = "customers" , ignore = true)
    @Mapping(target = "tournaments" , ignore = true)
    @Mapping(target = "computers" , ignore = true)
    ArenaGaming toEntity(ArenaGamingRequest arenaGamingRequest);
    ArenaGamingResponse toDTO(ArenaGaming arenaGaming);
    List<ArenaGamingResponse> toDTO(List<ArenaGaming>arenaGamings);
}