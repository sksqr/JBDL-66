package com.example.L17productapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);



    @Autowired
    private ProductService productService;
    @GetMapping("/{id}")
    ResponseEntity<Product> getProd(@PathVariable Long id){
        LOGGER.info("Processing Get Product API request for id : {}",id);
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    ResponseEntity<Product> create(@RequestBody Product product){
        LOGGER.info("Processing Create Product API : {}",product);
        return ResponseEntity.ok(productService.createProduct(product));
    }
}
