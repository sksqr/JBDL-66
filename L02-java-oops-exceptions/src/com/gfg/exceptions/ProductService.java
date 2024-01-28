package com.gfg.exceptions;

public class ProductService {

    public String getProductById(Integer id) throws ProductNotFoundException {
        if(id==1){
            return "Laptop";
        }
        throw new ProductNotFoundException("Not product with id:"+id, id);
    }
}
