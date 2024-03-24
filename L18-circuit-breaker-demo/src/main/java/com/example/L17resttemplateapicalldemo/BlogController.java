package com.example.L17resttemplateapicalldemo;

import com.example.L17resttemplateapicalldemo.dto.BlogDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${blog.service.baseUrl}")
    private String blogBaseUrl;

//    @GetMapping("/{id}")
//    public ResponseEntity<JsonNode> getBlog(@PathVariable Long id){
//        String url=blogBaseUrl+"/posts/"+id;
//        JsonNode jsonNode = restTemplate.getForObject(url,JsonNode.class);
//        return ResponseEntity.ok(jsonNode);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Long id){
        String url=blogBaseUrl+"/posts/"+id;
        BlogDto blogDto = restTemplate.getForObject(url,BlogDto.class);
        blogDto.setServerDateTime(new Date());
        return ResponseEntity.ok(blogDto);
    }


}
