package com.yyy.demo.base;

import beans.Person;
import configs.MainConfigOfProperties;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropertiesTest {

    //1.传入配置类的位置，如MainConfig.class
    AnnotationConfigApplicationContext annotationContext =
            new AnnotationConfigApplicationContext(MainConfigOfProperties.class);

    @Test
    public void test(){
        System.out.println("容器创建完成。。。");
        printBeans(annotationContext);

        Person p = (Person) annotationContext.getBean("person");
        System.out.println("person:"+ p);

        annotationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext context){
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println("beanName:"+ name);
        }
    }
}
