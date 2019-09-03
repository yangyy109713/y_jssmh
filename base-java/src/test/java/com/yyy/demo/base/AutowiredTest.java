package com.yyy.demo.base;

import configs.MainConfigAutowired;
import dao.BookDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

public class AutowiredTest {

    //1.传入配置类的位置，如MainConfig.class
    AnnotationConfigApplicationContext annotationContext =
            new AnnotationConfigApplicationContext(MainConfigAutowired.class);

    @Test
    public void test(){
        System.out.println("容器创建完成。。。");
        printBeans(annotationContext);

        BookService service = (BookService) annotationContext.getBean(BookService.class);
        System.out.println(service);

        BookDao bookDao = (BookDao) annotationContext.getBean(BookDao.class);
        //BookDaoImpl bookDao = (BookDaoImpl) annotationContext.getBean(BookDaoImpl.class);

        annotationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext context){
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println("beanName:"+ name);
        }
    }
}
