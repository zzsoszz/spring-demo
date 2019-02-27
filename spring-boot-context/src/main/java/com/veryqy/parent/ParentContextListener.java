package com.veryqy.parent;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ParentContextListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("ParentContextListener.onApplicationEvent:"+event.getApplicationContext().getEnvironment().getProperty("test.key1"));
    }

}
