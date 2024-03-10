package com.example.L14SpringDataRedisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private static Map<Long,Product> localCache = new HashMap<>();

    @Autowired
    private RedisTemplate<String,Product> redisTemplate;

    @Autowired
    private ProductRepo productRepo;

    public Product getById(Long id){
        //cache hit
//        if(localCache.containsKey(id)){
//            LOGGER.info("Cache Hit");
//            return localCache.get(id);
//        }
        String key = "product:"+id;
        Product product = redisTemplate.opsForValue().get(key);
        if(product != null){
            return product;
        }
        //cache miss
        LOGGER.info("Cache Miss");
         product = productRepo.findById(id).get();
        redisTemplate.opsForValue().set(key,product,5, TimeUnit.MINUTES);
        return product;
    }


    public Product getByIdWithLocalCache(Long id){
        //cache hit
        if(localCache.containsKey(id)){
            LOGGER.info("Cache Hit");
            return localCache.get(id);
        }
        //cache miss
        LOGGER.info("Cache Miss");
        Product product = productRepo.findById(id).get();
        localCache.put(product.getId(),product);
        return product;
    }

    public Long createProduct(Product product){
        product = productRepo.save(product);
        return product.getId();
    }
}
