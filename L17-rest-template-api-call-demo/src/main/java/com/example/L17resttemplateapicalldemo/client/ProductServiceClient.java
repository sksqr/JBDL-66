package com.example.L17resttemplateapicalldemo.client;

import com.example.L17resttemplateapicalldemo.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "product", url = "${product.service.baseUrl}")
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceClient {

    @PostMapping("/product")
    ProductDto createProd(@RequestBody ProductDto productDto);

    @GetMapping("/product/{id}")
    ProductDto getProd(@PathVariable Long id);

}
