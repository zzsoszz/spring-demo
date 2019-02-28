package com.veryqy.test;


/**
 * Spring Environment Property Source Configuration
 * https://stackoverflow.com/questions/14416005/spring-environment-property-source-configuration
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;


@Configuration
@ComponentScan(basePackages = {"com.veryqy.test"})
public class AppConfig {

    @EventListener(ContextStartedEvent.class)
    public void startup(){
        System.out.println("child startup..............");
    }

    @EventListener(ContextClosedEvent.class)
    public void closed(){
        System.out.println("child closed..............");
    }

    @EventListener(ContextRefreshedEvent.class)
    public void refresh(){
        System.out.println("child refresh..............");
    }

    @EventListener(ContextStoppedEvent.class)
    public void stoped(){
        System.out.println("child stoped..............");
    }

}
