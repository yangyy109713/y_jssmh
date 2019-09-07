package com.yyy.demo.base;

import aop.MathCalculator;
import configs.MainConfigAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_AOPTest {
    @Test
    public void test(){
        //1.传入配置类的位置
        AnnotationConfigApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(MainConfigAOP.class);
        System.out.println("容器创建完成。。。");

        //不要自己创建对象，使用Spring容器中的对象
        MathCalculator mathCalculator = annotationContext.getBean(MathCalculator.class);
        //mathCalculator.div(1, 1);//测试正常返回
        mathCalculator.div(1, 0);//测试异常

        annotationContext.close();
    }
}
