package com.example.L07LoggingMVCdemo.service;

import com.example.L07LoggingMVCdemo.Calculator;
import com.example.L07LoggingMVCdemo.Product;
import com.example.L07LoggingMVCdemo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private Calculator calculator;



    public List<Product> getAllData(){
        return productDAO.getAllData();
    }

    public Long createProduct(Product product){
        return productDAO.createProduct(product);
    }
}
