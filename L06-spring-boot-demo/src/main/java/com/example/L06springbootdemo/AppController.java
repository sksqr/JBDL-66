package com.example.L06springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hello")
    public String getHello(@RequestParam String name){
        return "Hello! "+name+" from :"+Thread.currentThread().getName();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    @PostMapping("/createProduct")
    public Long createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }


//    @PostMapping("/createProduct")
//    public Long createProduct2(@RequestBody Product product){
//        return productService.createProduct(product);
//    }


    @GetMapping("/products")
    public List<Product> getAll(){
        return productService.getProductList();
    }






    @GetMapping("/hello2")
    public String getHello2(){
        return "Hello2 from :"+Thread.currentThread().getName();
    }
}
