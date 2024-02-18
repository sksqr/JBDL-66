package com.example.L08restfullservicesdemo.controller;

import com.example.L08restfullservicesdemo.Product;
import com.example.L08restfullservicesdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        if(id<1){
            return ResponseEntity.badRequest().build();
        }
        Product product =  productService.getProductById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) throws URISyntaxException {
        productService.createProduct(product);
        URI uri = new URI("http://localhost:8080/product/"+product.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id){
        Product updatedProduct = productService.updateProduct(product,id);
        if(updatedProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id){
        Product deleteProduct = productService.deleteProduct(id);
        if(deleteProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deleteProduct);
    }


    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return  productService.getAllData();
    }

//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product){
//        productService.createProduct(product);
//        return ResponseEntity.ok(product);
//    }


}
