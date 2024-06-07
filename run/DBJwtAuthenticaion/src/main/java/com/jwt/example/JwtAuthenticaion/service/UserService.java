package com.jwt.example.JwtAuthenticaion.service;

import com.jwt.example.JwtAuthenticaion.entity.User;
import com.jwt.example.JwtAuthenticaion.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User creatUser(User user){
        user.setUserId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(user);
    }




}
