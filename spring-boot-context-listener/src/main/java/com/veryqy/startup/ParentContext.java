package com.veryqy.startup;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Spring Boot深入原理 - SpringApplication启动原理
 * http://www.majunwei.com/view/201708231840127244.html
 */

public class ParentContext implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        //System.out.println(event.get);
    }

}
