package domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {
    public Dog() {
        System.out.println("dog constructor");
    }

    //对象创建并赋值后调用
    @PostConstruct
    public void init() {
        System.out.println("dog constructor..PostConstruct.");
    }

    //容器销毁之前调用
    @PreDestroy
    public void destroy() {
        System.out.println("dog destroy ..PreDestroy.");
    }
}