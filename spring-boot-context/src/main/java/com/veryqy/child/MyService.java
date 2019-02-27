package com.veryqy.child;


import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@MyPropertiesSource
public class MyService {

    @Value("${name}")
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
