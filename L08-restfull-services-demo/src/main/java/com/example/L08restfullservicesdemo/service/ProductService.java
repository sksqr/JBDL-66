package com.example.L08restfullservicesdemo.service;


import com.example.L08restfullservicesdemo.Product;
import com.example.L08restfullservicesdemo.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Product updateProduct( Product product, Long id){
        Product existingProduct = productDAO.getProductById(id);
        if(existingProduct == null){
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setCost(product.getCost());
        return existingProduct;
    }

    public Product deleteProduct(Long id){
        return productDAO.deleteProduct(id);
    }
}
