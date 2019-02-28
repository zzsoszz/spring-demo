package com.veryqy.module1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module1Configuration {

    @Bean
    public User user(){
        User user=new User();
        user.setName("qingtian");
        user.setPassword("123456");
        return user;
    }

}
