package com.example.L17productapp;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {
    private AtomicLong nextId = new AtomicLong(0);

    private Map<Long,Product> productStore = new HashMap<>();

    public Product createProduct(Product product){
        product.setId(nextId.incrementAndGet());
        productStore.put(product.getId(), product);
        return product;
    }

    public Product getProduct(Long id){
        return productStore.get(id);
    }
}
