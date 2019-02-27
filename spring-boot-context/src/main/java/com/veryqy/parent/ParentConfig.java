package com.veryqy.parent;


/**
 * Spring Environment Property Source Configuration
 * https://stackoverflow.com/questions/14416005/spring-environment-property-source-configuration
 */

import com.veryqy.child.MyPropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.veryqy.parent"})
public class ParentConfig {

//    @Bean
//    public MyPropertySourcesPlaceholderConfigurer configSourcesConfigurer(){
//        MyPropertySourcesPlaceholderConfigurer configSourcesConfigurer=   new MyPropertySourcesPlaceholderConfigurer();
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("parent.name","三名");
//        MapPropertySource mapPropertySource=new MapPropertySource("person",map);
//        List<PropertySource> propertySourceList=new ArrayList<PropertySource>();
//        propertySourceList.add(mapPropertySource);
//        configSourcesConfigurer.setPropertySources(propertySourceList);
//        return  configSourcesConfigurer;
//    }

}
