package com.veryqy.module1;

/**
 * Spring boot加载外部配置文件-EnvironmentPostProcessor
 * https://blog.csdn.net/u011659172/article/details/79011366
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class ModuleEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver=new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources =  pathMatchingResourcePatternResolver.getResources("classpath:*.properties" );
            for(Resource resource:resources){
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                PropertiesPropertySource propertySource = new PropertiesPropertySource(resource.getFilename(), properties);
                environment.getPropertySources().addLast(propertySource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


//        try(InputStream input = new FileInputStream("E:\\ds.properties")) {
//            Properties properties = new Properties();
//            properties.load(input);
//            PropertiesPropertySource propertySource = new PropertiesPropertySource("ve", properties);
//            environment.getPropertySources().addLast(propertySource);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }