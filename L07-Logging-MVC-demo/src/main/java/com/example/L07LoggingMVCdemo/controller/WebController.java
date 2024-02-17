package com.example.L07LoggingMVCdemo.controller;


import com.example.L07LoggingMVCdemo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/page")
//    @ResponseBody
    public String getPage(){
        return "static-page.html";
    }

    @GetMapping("/dynamic-menu")
    public ModelAndView getMenu(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1l,"laptop",5000.0));
        products.add(new Product(2l,"pen",5000.0));
        ModelAndView modelAndView = new ModelAndView("dynamic-page.html");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        modelAndView.getModelMap().put("serverTime",dateFormat.format(new Date()));
        modelAndView.getModelMap().put("products",products);
        return modelAndView;
    }

}
