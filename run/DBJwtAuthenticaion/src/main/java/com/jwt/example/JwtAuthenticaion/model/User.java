package com.jwt.example.JwtAuthenticaion.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {


    private Integer userId;
    private String name;
    private String email;


    public User(String string, String durgesh, String mail) {
    }
}




