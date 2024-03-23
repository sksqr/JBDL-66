package com.example.L17eurekaserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class L17EurekaServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L17EurekaServerDemoApplication.class, args);
	}

}
