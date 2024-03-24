package com.example.L17resttemplateapicalldemo;

import com.example.L17resttemplateapicalldemo.client.ProductServiceClient;
import com.example.L17resttemplateapicalldemo.dto.ProductDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy")
public class ProductProxyController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductProxyController.class);

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private RestTemplate restTemplate;


    @Value("${product.service.baseUrl}")
    private String productBaseUrl;

    @Autowired
    private ProductServiceClient productServiceClient;

//    @PostMapping("/createProduct")
//    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
//        String url = productBaseUrl+"/product";
//        ProductDto productDto1 =  restTemplate.postForEntity(url,productDto,ProductDto.class).getBody();
//        return ResponseEntity.ok(productDto1);
//    }


    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        LOGGER.info("Processing createProduct request : {}",productDto);
        ProductDto productDto1 =  productServiceClient.createProd(productDto);
        return ResponseEntity.ok(productDto1);
    }


    @GetMapping("/getproduct/{id}")
    public ResponseEntity<ProductDto> getProd(@PathVariable Long id){
        LOGGER.info("Processing getproduct id : {}",id);
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cb01");
        ProductDto productDto = circuitBreaker.run(() -> productServiceClient.getProd(id), throwable -> fallbackMethodForGetProduct());
        return ResponseEntity.ok(productDto);
    }


    public ProductDto fallbackMethodForGetProduct(){
        return new ProductDto(1l,"Dummy Product", 1000.00);
    }
}
