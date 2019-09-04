package com.yyy.demo.base;

import configs.MainConfigAutowired;
import dao.BookDao;
import dao.BookDaoImpl;
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
        System.out.println("属性bookDao = "+ service);//打印结果：属性bookDao = 实现类bookDaoImpl对象
        service.printDao();//打印结果：实现类bookDaoImpl对象

        BookDao bookDao = (BookDao) annotationContext.getBean(BookDao.class);
        System.out.println(bookDao);//打印的是实现类bookDaoImpl对象
        BookDaoImpl bookDaoImpl = (BookDaoImpl) annotationContext.getBean(BookDaoImpl.class);
        System.out.println(bookDaoImpl);

        annotationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext context){
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames){
            System.out.println("beanName:"+ name);
        }
    }
}
