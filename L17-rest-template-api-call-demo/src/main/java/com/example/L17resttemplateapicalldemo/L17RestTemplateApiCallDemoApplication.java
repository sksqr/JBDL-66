package com.example.L17resttemplateapicalldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class L17RestTemplateApiCallDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L17RestTemplateApiCallDemoApplication.class, args);
	}

}
