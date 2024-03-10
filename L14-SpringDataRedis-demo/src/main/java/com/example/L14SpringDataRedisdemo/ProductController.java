package com.example.L14SpringDataRedisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable Long id){
        Product product = productService.getById(id);
        //Product product = productService.getByIdWithLocalCache(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Long id = productService.createProduct(product);
        URI uri = null;
        try {
            uri = new URI("/product/"+id);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.created(uri).build();
    }

}
