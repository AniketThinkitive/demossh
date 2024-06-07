//package com.jwt.example.JwtAuthenticaion.controller;
//
//
//import com.jwt.example.JwtAuthenticaion.entity.User;
//import com.jwt.example.JwtAuthenticaion.service.UserServiceInterface;
//import com.jwt.example.JwtAuthenticaion.serviceImplementation.UserImplementation;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/user")
//public class UserRestController {
//
//
//
//    private  final UserServiceInterface userServiceInterface;
//
//    public UserRestController(UserServiceInterface userServiceInterface) {
//        this.userServiceInterface = userServiceInterface;
//
//    }
//
//
//
// @PostMapping("/save")
//    public ResponseEntity<String> saveUser(@RequestBody User user){
//        Integer id=userServiceInterface.saveUser(user);
//    String body="User +"+id+" saved";
//        return  ResponseEntity.ok(body);
// }
//}
