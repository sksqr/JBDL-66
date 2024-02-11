package com.example.L06springbootdemo;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {

    private List<Product> productList;

    @PostConstruct
    public void initMethod(){
        productList = new ArrayList<>();
    }

    public Product getProductById(Long id){
       return new Product(id,"Laptop",1000.00);
    }

    public Long createProduct(Product product){
        productList.add(product);
        return product.getId();
    }

    public List<Product> getProductList(){
        return productList;
    }
}
