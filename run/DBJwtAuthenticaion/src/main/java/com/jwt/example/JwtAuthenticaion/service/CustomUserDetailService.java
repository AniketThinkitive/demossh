package com.jwt.example.JwtAuthenticaion.service;

import com.jwt.example.JwtAuthenticaion.entity.User;
import com.jwt.example.JwtAuthenticaion.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {


    private final UserRepository userRepository;
    public CustomUserDetailService( UserRepository userRepository) {

        this.userRepository = userRepository;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//////        UserDetails userDetail = User.builder().username("harsh").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
//////        UserDetails userDetail1 = User.builder().username("durgesh").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
////
//        return  null;    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User user= userRepository.findByEmail(username).orElseThrow(()->new RuntimeException("User Not Found!!!"));
        return user;
    }
}
