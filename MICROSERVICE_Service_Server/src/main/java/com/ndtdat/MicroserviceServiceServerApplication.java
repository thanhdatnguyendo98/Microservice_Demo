package com.ndtdat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroserviceServiceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServiceServerApplication.class, args);
	}

}
