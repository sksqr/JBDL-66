package com.example.L07LoggingMVCdemo.controller;


import com.example.L07LoggingMVCdemo.Product;
import com.example.L07LoggingMVCdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return  productService.getAllData();
    }

    @PostMapping
    public Long createProduct(@RequestBody Product product){
        return  productService.createProduct(product);
    }
}
