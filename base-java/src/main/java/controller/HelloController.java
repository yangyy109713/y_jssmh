package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/helloworld")
    public String helloworld() {
        return "Hello Spring Boot World!";
    }

    @RequestMapping("/index")
    @ResponseBody
    public Map<String, String> index() {
        Map map = new HashMap<String, String>();
        map.put("北京", "北方城市");
        map.put("上海", "南方城市");
        return map;
    }
}
