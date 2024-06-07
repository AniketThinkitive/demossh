package com.jwt.example.JwtAuthenticaion;

import com.jwt.example.JwtAuthenticaion.security.Test;
import io.jsonwebtoken.Claims;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthenticaionApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JwtAuthenticaionApplication.class, args);
		System.out.println("DB Jwt oauth reunning");


}
}

