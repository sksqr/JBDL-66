package com.example.L08JDBCdemo.service;


import com.example.L08JDBCdemo.Product;
import com.example.L08JDBCdemo.dao.ProductDAO;
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
//        return productDAO.createProduct(product);
    //    return productDAO.createProductWithPS(product);
        return productDAO.createProductWithPSWithTxn(product);
    }

    public Product updateProduct( Product product, Long id){
        Product existingProduct = productDAO.updateProduct(product,id);
        return existingProduct;
    }

    public Product deleteProduct(Long id){
        return productDAO.deleteProduct(id);
    }
}
