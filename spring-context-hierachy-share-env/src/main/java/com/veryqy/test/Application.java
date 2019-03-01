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
 */

import com.veryqy.parent.HelloService;
import com.veryqy.parent.ParentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {

    public static void main(String[] args) {
        ApplicationContext parent = new AnnotationConfigApplicationContext(ParentConfig.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ((AnnotationConfigApplicationContext) ctx).setParent(parent);
        ((AnnotationConfigApplicationContext) ctx).start();
        HelloService helloService = ctx.getBean(HelloService.class);
        helloService.say();
        LucyHelloService lucyHelloService = ctx.getBean(LucyHelloService.class);
        lucyHelloService.say();
        String appName=parent.getEnvironment().getProperty("app.name");
        String childAppName=ctx.getEnvironment().getProperty("app.name");
        System.out.println(appName);
        System.out.println(childAppName);
//        ((AnnotationConfigApplicationContext) ctx).close();
//        ((AnnotationConfigApplicationContext) ctx).refresh();;

    }

}


//        String msg=ctx.getEnvironment().getProperty("app.name");
//        String appName=parent.getEnvironment().getProperty("app.name");
//        System.out.println(appName);
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//CommonAnnotationBeanPostProcessor
//AutowiredAnnotationBeanPostProcessor
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
//        LucyHelloService myService = ctx.getBean(LucyHelloService.class);
//        System.out.println( ctx.containsBean("myService"));
//        myService.say();
//       ctx.getAutowireCapableBeanFactory().destroyBean("myService");
//        //((AnnotationConfigApplicationContext) ctx).getBeanFactory().destroySingletons();
////        ((AnnotationConfigApplicationContext) ctx).refresh();
//        System.out.println( ctx.containsBean("myService"));
//        LucyHelloService myService2 = ctx.getBean(LucyHelloService.class);
//        myService2.say();
//        //((DefaultListableBeanFactory) ctx).destroyBean();
//DatabaseConfiguration a;