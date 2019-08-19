package com.yyy.demo.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProviderTest {

    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
        context.start();
        System.out.println("Provider started.");
        System.in.read(); // press any key to exit
    }
}
