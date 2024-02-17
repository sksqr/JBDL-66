package com.example.L07LoggingMVCdemo.controller;

import com.example.L07LoggingMVCdemo.scope.PrototypeBean;
import com.example.L07LoggingMVCdemo.scope.RequestBean;
import com.example.L07LoggingMVCdemo.scope.SingletonBean;
import com.example.L07LoggingMVCdemo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class ScopeController {

    private static Logger LOGGER = LoggerFactory.getLogger(ScopeController.class);

    private Set<RequestBean> requestBeanSet = new HashSet<>();

    private Set<PrototypeBean> prototypeBeanSet = new HashSet<>();

    @Autowired
    private ApplicationContext applicationContext;


    @GetMapping("/getScopes")
    public String getScopes(){



        SingletonBean singletonBean1 = (SingletonBean) applicationContext.getBean("singletonBean");
        SingletonBean singletonBean2 = (SingletonBean) applicationContext.getBean("singletonBean");

        LOGGER.info("singletonBean1 == singletonBean2 : {}",singletonBean1 == singletonBean2);

        PrototypeBean prototypeBean1 = (PrototypeBean) applicationContext.getBean("prototypeBean");
        PrototypeBean prototypeBean2 = (PrototypeBean) applicationContext.getBean("prototypeBean");
        prototypeBeanSet.add(prototypeBean1);
        prototypeBeanSet.add(prototypeBean2);
        LOGGER.info("prototypeBean1 == prototypeBean1 : {}",prototypeBean1 == prototypeBean2);
        LOGGER.info("Size of prototypeBeanSet: {}",prototypeBeanSet.size());

        requestBeanSet.add((RequestBean) applicationContext.getBean("requestBean"));
        requestBeanSet.add((RequestBean) applicationContext.getBean("requestBean"));

        LOGGER.info("Size of requestBeanSet: {}",requestBeanSet.size());
        return "Done";
    }

}
