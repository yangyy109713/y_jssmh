package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService service;

    @ResponseBody //使用该注解，表示可以直接返回结果，不用配置hello方法返回值的对应页面
    @RequestMapping(value = "/hello")
    public String hello(){
        String str = service.sayHello("YYY");
        //return "success";
        return str;
    }

    @RequestMapping(value = "success")
    public String success(){
        return "success";
    }
}
