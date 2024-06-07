//package com.jwt.example.JwtAuthenticaion.entity;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Set;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Entity
//@Table(name="usertable")
//public class User {
//    @Id
//    @GeneratedValue
//    private Integer userId;
//    private String name;
//    private String userName;
//    private String password;
//
//    @ElementCollection
//    @CollectionTable(
//            name="roleTable",
//            joinColumns = @JoinColumn(name="id")
//    )
//    @Column(name="role")
//    private Set<String> roles;
//
//}
