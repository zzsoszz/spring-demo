package com.veryqy.test;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PropertiesAnaotationBeanFactoryProcessor implements BeanFactoryPostProcessor, ApplicationListener<MyEnvironmentChange> {

    String beanNames[];
    ConfigurableListableBeanFactory beanFactory;

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanNames= beanFactory.getBeanNamesForAnnotation(MyPropertiesSource.class);
        this.beanFactory=beanFactory;
    }


    public void onApplicationEvent(MyEnvironmentChange event) {
        for(String beanName:beanNames){
            Object instance = beanFactory.getBean(beanName);
            if (AopUtils.isAopProxy(instance)) {
                instance = getTargetObject(instance);
            }
            beanFactory.destroyBean(instance);
            beanFactory.initializeBean(instance,beanName);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T getTargetObject(Object candidate) {
        try {
            if (AopUtils.isAopProxy(candidate) && (candidate instanceof Advised)) {
                return (T) ((Advised) candidate).getTargetSource().getTarget();
            }
        }
        catch (Exception ex) {
            throw new IllegalStateException("Failed to unwrap proxied object", ex);
        }
        return (T) candidate;
    }


}
