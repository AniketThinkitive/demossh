package com.microapiempmanage.Eservice_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EserviceRegistryApplication {

	public static void main(String[] args) {

		SpringApplication.run(EserviceRegistryApplication.class, args);
		System.out.println("Service -registry");
	}

}
