package com.example.L07restfullservicesdemo.service;


import com.example.L07restfullservicesdemo.Product;
import com.example.L07restfullservicesdemo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;


    public List<Product> getAllData(){
        return productDAO.getAllData();
    }
    public Product getProductById(Long id){
        return  productDAO.getProductById(id);
    }

    public Long createProduct(Product product){
        return productDAO.createProduct(product);
    }
}
