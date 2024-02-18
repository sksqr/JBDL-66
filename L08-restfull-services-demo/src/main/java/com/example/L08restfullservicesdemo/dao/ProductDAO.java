package com.example.L08restfullservicesdemo.dao;


import com.example.L08restfullservicesdemo.Product;
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

    public Product deleteProduct(Long id){
        Product exitingProduct = dataStore.get(id);
        if(exitingProduct != null){
            dataStore.remove(id);
        }
        return exitingProduct;
    }
}
