package com.veryqy.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LucyHelloService {

    @Value("${app.name}")
    String name;

    public void say(){
        System.out.println("hello:"+name);
    }

    @PostConstruct
    public void init(){
        System.out.println("init.....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("desctroy.....");
    }

}
