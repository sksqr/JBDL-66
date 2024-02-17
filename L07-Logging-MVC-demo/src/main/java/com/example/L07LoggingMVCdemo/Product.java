package com.example.L07LoggingMVCdemo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private Long id;

    private String name;

    private Double cos;
}
