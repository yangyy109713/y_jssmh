package com.yyy.demo.base;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tx.MainConfigTx;
import tx.UserService;

public class IOC_TxTest {

    @Test
    public void test(){
        //1.传入配置类的位置
        AnnotationConfigApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(MainConfigTx.class);
        System.out.println("容器创建完成。。。");

        String[] definitionNames = annotationContext.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println("beanName:"+ name);
        }

        UserService userService = annotationContext.getBean(UserService.class);
        userService.insertUser();

        annotationContext.close();
    }
}
/**
 * 执行测试方法时，起初一直报错：
 * Connections could not be acquired from the underlying database!
 * 查找原因，最后发现是application.properties中密码写错了。。。。
 */
