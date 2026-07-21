package com.rivalix.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivalix.backend.entity.ArenaGaming;

public interface ArenaGamingRepository extends JpaRepository<ArenaGaming,Long>{
    Optional <ArenaGaming> findByName(String name);
    boolean existsByName(String name);
}