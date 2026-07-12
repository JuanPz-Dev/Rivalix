package com.rivalix.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivalix.backend.entity.User;
import com.rivalix.backend.enums.Rol;

public interface UserRepository extends JpaRepository<User,Long>{
   Optional <User> findByEmail (String email);
   boolean existsByEmail (String email);
   List <User> findByRole (Rol rol);
}