package com.veryqy.test;


/**
 * Spring Environment Property Source Configuration
 * https://stackoverflow.com/questions/14416005/spring-environment-property-source-configuration
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.veryqy.test"})
public class AppConfig {

    @Bean
    MyService myService(){
        return new MyService();
    }

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
        System.out.println("a context refreshed event happened");
    }

    @Bean
    public MyPropertySourcesPlaceholderConfigurer configSourcesConfigurer(){
        MyPropertySourcesPlaceholderConfigurer configSourcesConfigurer=   new MyPropertySourcesPlaceholderConfigurer();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","wang");
        map.put("age",23);
        MapPropertySource mapPropertySource=new MapPropertySource("person",map);
        List<PropertySource> propertySourceList=new ArrayList<PropertySource>();
        propertySourceList.add(mapPropertySource);
        configSourcesConfigurer.setPropertySources(propertySourceList);
        return  configSourcesConfigurer;
    }

}
