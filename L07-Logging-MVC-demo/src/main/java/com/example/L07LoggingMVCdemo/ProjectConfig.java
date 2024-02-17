package com.example.L07LoggingMVCdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Calculator getCalculator(){
        return new Calculator();
    }

}
