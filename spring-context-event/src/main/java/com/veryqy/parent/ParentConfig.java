package com.veryqy.parent;


/**
 * Spring Environment Property Source Configuration
 * https://stackoverflow.com/questions/14416005/spring-environment-property-source-configuration
 */

import com.veryqy.test.MyPropertySourcesPlaceholderConfigurer;
import com.veryqy.test.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.veryqy.parent"})
public class ParentConfig {

    @EventListener(ContextStartedEvent.class)
    public void startup(){
        System.out.println("startup..............");
    }

    @Bean
    public MyPropertySourcesPlaceholderConfigurer configSourcesConfigurer(){
        MyPropertySourcesPlaceholderConfigurer configSourcesConfigurer=   new MyPropertySourcesPlaceholderConfigurer();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("app.name","三名");
        MapPropertySource mapPropertySource=new MapPropertySource("person",map);
        List<PropertySource> propertySourceList=new ArrayList<PropertySource>();
        propertySourceList.add(mapPropertySource);
        configSourcesConfigurer.setPropertySources(propertySourceList);
        return  configSourcesConfigurer;
    }

}
