package com.veryqy.test;
/**
 * 深入理解SpringCloud之配置刷新
 * https://www.cnblogs.com/niechen/p/8979578.html
 * ConfigurationPropertiesRebinder
 *
 * spring的启动过程04.1-value注解替换过程
 * https://blog.csdn.net/qq_28580959/article/details/60129329
 *
 * Spring注解之后置处理器
 * https://blog.csdn.net/u014297148/article/details/80412991
 *
 *  Spring源码：bean创建（四）属性注入
 *  https://blog.csdn.net/finalcola/article/details/81504547
 *
 * 【Spring源码分析】非懒加载的单例Bean初始化过程（下篇）
 *  https://www.cnblogs.com/xrq730/p/6363055.html
 *  AbstractAutowireCapableBeanFactory的doCreateBean
 *
 *   Spring核心学习（3）为Bean注入属性
 *   https://blog.csdn.net/u011345136/article/details/45602421
 *
 * BeanPostProcessor自定义bean加载后属性注入
 * https://blog.csdn.net/fzghjx/article/details/81266393
 * https://blog.csdn.net/fzghjx/article/details/81266393
 *
 * Spring 常用的一些工具类
 * https://www.cnblogs.com/lynn-lkp/p/6258088.html
 *
 * apache beanutils
 * http://commons.apache.org/proper/commons-beanutils/javadocs/v1.9.3/apidocs/org/apache/commons/beanutils/package-summary.html#package_description
 *
 * Using PropertySourcesPlaceholderConfigurer to retrieve values from properties file as well as database
 * https://stackoverflow.com/questions/45416615/using-propertysourcesplaceholderconfigurer-to-retrieve-values-from-properties-fi
 *
 * creating custom PropertySourcesPlaceholderConfigurer using property loaded dynamically
 * https://stackoverflow.com/questions/25985032/creating-custom-propertysourcesplaceholderconfigurer-using-property-loaded-dynam
 *
 * Spring Bean的生命周期（非常详细）
 * https://blog.csdn.net/u010342038/article/details/52788687
 *
 * spring 生命周期最详解
 * https://blog.csdn.net/qq_23473123/article/details/76610052
 *
 * boot-features-spring-application
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-spring-application.html
 */

import com.veryqy.child.AppConfig;
import com.veryqy.child.AppPropertiesSource;
import com.veryqy.parent.ParentConfig;
import com.veryqy.parent.ParentPropertiesSource;
import javafx.scene.Parent;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder()
                .sources(ParentConfig.class)
                .child(AppConfig.class)
                .properties("key1:test1", "key2:test2")
                .build()
                .run(args);

        for (String beanName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanName + " : " + ctx.getBean(beanName).getClass().toString());
        }

        AppPropertiesSource appPropertiesSource = ctx.getBean(AppPropertiesSource.class);
        ParentPropertiesSource parentPropertiesSource = ctx.getBean(ParentPropertiesSource.class);
        System.out.println("app.name:"+ctx.getEnvironment().getProperty("test.key1"));
        System.out.println(appPropertiesSource.getKey1());
        System.out.println(parentPropertiesSource.getKey1());
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


//ctx.addApplicationListener(new AppContextListener());
//    @Value("${key1}")
//    String val;
//application = new SpringApplicationBuilder()
//        .parent(new Object[]{"classpath:file1.xml", "classpath:file2.xml"})
//        .profiles("abc")
//        .properties("key1:test1", "key2:test2")
//        .showBanner(false)
//        .logStartupInfo(true)
//        .headless(true)
//        .application()
//        .run();
//        Now, retrieve the propert

//        ApplicationContext parent = new AnnotationConfigApplicationContext(ParentConfig.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        ((AnnotationConfigApplicationContext) ctx).setParent(parent);
//        MyService myService = ctx.getBean(MyService.class);
//        myService.say();
//        ctx.publishEvent(new MyEnvironmentChange("myService"));
//        MyService myService2 = ctx.getBean(MyService.class);
//        myService2.say();
//        String msg=ctx.getEnvironment().getProperty("app.name");
//        String appName=parent.getEnvironment().getProperty("app.name");
//        System.out.println(appName);
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



//        DefaultListableBeanFactory a;
//        DefaultListableBeanFactory
//        AutowiredAnnotationBeanPostProcessor k;
//        InstantiationAwareBeanPostProcessorAdapter b;
//        AbstractAutowireCapableBeanFactory c;//doCreateBean
//        ApplicationContextInitializer f;//initialize
//        ClassPathXmlApplicationContext g;//refresh
//        DefaultListableBeanFactory h;
//        GenericXmlApplicationContext i;
//        ConfigurableApplicationContext j;//addBeanFactoryPostProcessor refresh
/*
ClassUtils
ReflectionUtil
FileSystemUtils
FileCopyUtils
ResourceUtils
PropertiesLoaderUtils
StreamUtils
ReflectionUtils
ResourceUtils
CollectionUtils
DigestUtils
SystemPropertyUtils
*/
//ConfigurationPropertiesBindingPostProcessor a;
//ConfigurationPropertiesBindingPostProcessor

//System.out.println( ctx.containsBean("myService"));
//        for (String beanName : ctx.getBeanDefinitionNames()) {
//            System.out.println(beanName + " : " + ctx.getBean(beanName).getClass().toString());
//        }
//        //((AnnotationConfigApplicationContext) ctx).register();;
//
//        MyService myService = ctx.getBean(MyService.class);
//        System.out.println( ctx.containsBean("myService"));
//        myService.say();
//       ctx.getAutowireCapableBeanFactory().destroyBean("myService");
//        //((AnnotationConfigApplicationContext) ctx).getBeanFactory().destroySingletons();
////        ((AnnotationConfigApplicationContext) ctx).refresh();
//        System.out.println( ctx.containsBean("myService"));
//        MyService myService2 = ctx.getBean(MyService.class);
//        myService2.say();
//        //((DefaultListableBeanFactory) ctx).destroyBean();
//DatabaseConfiguration a;
//CommonAnnotationBeanPostProcessor
//AutowiredAnnotationBeanPostProcessor