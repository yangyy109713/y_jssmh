package com.yyy.demo.dubbo;

import dubboapi.test.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboConsumerTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        /*context.start();
        System.out.println("Consumer started.");
        System.in.read(); // press any key to exit*/

        OrderService orderService = context.getBean(OrderService.class);
        orderService.initOrder("1");

        System.out.println("Consumer 调用user-service完成.");
        System.in.read();
    }
}
