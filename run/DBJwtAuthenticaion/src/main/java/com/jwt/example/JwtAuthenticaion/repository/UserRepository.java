package com.jwt.example.JwtAuthenticaion.repository;

import com.jwt.example.JwtAuthenticaion.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

public Optional<User> findByEmail (String email);



}
