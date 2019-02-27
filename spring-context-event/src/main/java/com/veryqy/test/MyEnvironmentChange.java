package com.veryqy.test;

import org.springframework.context.ApplicationEvent;

public class MyEnvironmentChange extends ApplicationEvent {
    public MyEnvironmentChange(Object source) {
        super(source);
    }
}
