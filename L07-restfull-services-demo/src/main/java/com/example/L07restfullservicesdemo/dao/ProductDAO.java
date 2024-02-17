package com.example.L07restfullservicesdemo.dao;


import com.example.L07restfullservicesdemo.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDAO {
    private Map<Long, Product> dataStore = new HashMap<>();
    private Long nextId=0l;
    public List<Product> getAllData(){
        return dataStore.values().stream().toList();
    }
    public Long createProduct(Product product){
        nextId++;
        product.setId(nextId);
        dataStore.put(product.getId(),product);
        return product.getId();
    }
    public Product getProductById(Long id){
        return  dataStore.get(id);
    }
}
