package com.veryqy.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import java.util.List;


public class MyPropertySourcesPlaceholderConfigurer
        extends PropertySourcesPlaceholderConfigurer
        implements EnvironmentAware, InitializingBean {

    private Environment environment;
    private List<PropertySource> sourceList;

    @Override
    public void setEnvironment(Environment environment) {
        // save off Environment for later use
        this.environment = environment;
        super.setEnvironment(environment);
    }

    public void afterPropertiesSet() throws Exception {
        // Copy property sources to Environment
        MutablePropertySources envPropSources = ((ConfigurableEnvironment)environment).getPropertySources();
        copyListToPropertySources(this.sourceList, envPropSources);
    }

    // Allow setting property sources as a List for easier XML configuration
    public void setPropertySources(List<PropertySource> propertySources) {
        this.sourceList = propertySources;
        MutablePropertySources sources = new MutablePropertySources();
        copyListToPropertySources(this.sourceList, sources);
        super.setPropertySources(sources);
    }

    private void copyListToPropertySources(List<PropertySource> list, MutablePropertySources sources) {
        // iterate in reverse order to insure ordering in property sources object
        for(int i = list.size() - 1; i >= 0; i--) {
            sources.addFirst(list.get(i));
        }
    }
}
