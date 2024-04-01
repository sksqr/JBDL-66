package com.gfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionApp {

    @Bean
    public RequestFilter requestFilter(){
        return new RequestFilter();
    }
    public static void main(String[] args) {
        SpringApplication.run(TransactionApp.class,args);
    }
}