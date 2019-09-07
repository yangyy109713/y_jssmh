package com.yyy.demo.base;

import configs.MainConfiProfile;
import domain.Red;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * 切换数据源的方式
 * 1.使用命令行参数：右键 - Run Configuration
 *  在虚拟机参数位置 设置运行时环境：-Dspring.profiles.active=dev
 * 2.使用代码方式
 *  1）创建AnnotationConfigApplicationContext对象
 *  2）设置需要激活的环境
 *  3）注册主配置类
 *  4）启动刷新容器
 */
public class PropertiesTest {

    //1.传入配置类的位置，MainConfiProfile.class
    AnnotationConfigApplicationContext annotationContext =
            new AnnotationConfigApplicationContext(MainConfiProfile.class);

    //未指定任何环境
    @Test
    public void test(){
        System.out.println("容器创建完成。。。");
        String[] nameForTypes = annotationContext.getBeanNamesForType(DataSource.class);//根据类型获取容器中Bean的名字
        for (String name : nameForTypes) {
            System.out.println("NameOfDataSource: "+ name);
        }

        Red red = annotationContext.getBean(Red.class);
        System.out.println(red);

        annotationContext.close();
    }

    //使用代码方式指定数据源
    @Test
    public void codeChangeEnvironment(){
        //创建AnnotationConfigApplicationContext对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //设置需要激活的环境
        context.getEnvironment().setActiveProfiles("prod", "dev");//可以一次指定多个环境
        //注册主配置类
        context.register(MainConfiProfile.class);
        //启动刷新容器
        context.refresh();

        System.out.println("容器创建完成。。。");
        String[] nameForTypes = context.getBeanNamesForType(DataSource.class);//根据类型获取容器中Bean的名字
        for (String name : nameForTypes) {
            System.out.println("NameOfDataSource: "+ name);
        }

        Red red = context.getBean(Red.class);//当给整个配置类指定环境时，如果环境标识不一致，则整个类都不加在，会报错No qualifying bean of type 'domain.Red' available
        System.out.println(red);
    }
}
