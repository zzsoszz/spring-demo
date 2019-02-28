package com.veryqy.parent;


/**
 * Spring Environment Property Source Configuration
 * https://stackoverflow.com/questions/14416005/spring-environment-property-source-configuration
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;

@Configuration
@ComponentScan(basePackages = {"com.veryqy.parent"})
public class ParentConfig {

    @EventListener(ContextStartedEvent.class)
    public void startup(){
        System.out.println("parent startup..............");
    }

    @EventListener(ContextClosedEvent.class)
    public void closed(){
        System.out.println("parent closed..............");
    }

    @EventListener(ContextRefreshedEvent.class)
    public void refresh(){
        System.out.println("parent refresh..............");
    }

    @EventListener(ContextStoppedEvent.class)
    public void stoped(){
        System.out.println("parent stoped..............");
    }

}
