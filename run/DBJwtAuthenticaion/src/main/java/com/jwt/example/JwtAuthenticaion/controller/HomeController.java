package com.jwt.example.JwtAuthenticaion.controller;


import com.jwt.example.JwtAuthenticaion.entity.User;
//import com.jwt.example.JwtAuthenticaion.entity.Userjwt;
import com.jwt.example.JwtAuthenticaion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


//user
//0cec5a61-f80b-408a-a454-c428f36143fc

//jwt = json web token

//http://localhost:9091/home/users

@RestController
@RequestMapping("/home")
public class HomeController {

private  final UserService userService;
private  final UserDetailsService userDetailsService;
    @Autowired
    public HomeController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/users")
    public List<User> getUser(){
        System.out.println("getting users");
        return this.userService.getUsers();
    }
//
//    @GetMapping("/users")
//    public List<User> getUser(){
//        System.out.println("getting users");
//       List<User>=  userService.getUsers();
//        return  userDetailsService.loadUserByUsername(user)
//    }

    @GetMapping("/currentuser")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }


}
