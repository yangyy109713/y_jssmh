package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

public class AsyncController {

    @ResponseBody
    @RequestMapping(value = "/async01")
    public Callable<String> async01(){

        System.out.println("主线程开始。。。" + System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("副线程开始。。。" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("副线程结束。。。" + System.currentTimeMillis());
                return "Callable<String> async01()";
            }
        };

        System.out.println("主线程结束。。。" + System.currentTimeMillis());
        return callable;
    }
}
