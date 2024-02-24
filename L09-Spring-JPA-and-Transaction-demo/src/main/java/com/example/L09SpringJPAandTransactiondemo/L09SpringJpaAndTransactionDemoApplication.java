package com.example.L09SpringJPAandTransactiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class L09SpringJpaAndTransactionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L09SpringJpaAndTransactionDemoApplication.class, args);
	}

}
