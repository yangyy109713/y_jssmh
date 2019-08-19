package com.yyy.demo.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 */
@EnableDubbo //开启基于注解的dubbo功能
@SpringBootApplication  //Spring Boot 应用的标识
public class DubboClientApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(DubboClientApplication.class, args);
    }
}
