package com.yyy.demo.base;

import configs.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCBeanLifeTest {

    @Test
    public void test() {
        //1.传入配置类的位置，如MainConfig.class
        AnnotationConfigApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成。。。");

        annotationContext.close();
    }
}
