package com.yyy.demo.dubbo.controller;

import dubboapi.test.bean.City;
import dubboapi.test.bean.UserAddress;
import dubboapi.test.service.CityDubboService;
import dubboapi.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService service;

    @Autowired
    CityDubboService cityDubboService;

    //接口返回一个json串：以@ResponseBody注解标识
    @ResponseBody
    //接口请求映射：以@RequestMapping("/initOrder")注解标识，参数表示请求路径
    @RequestMapping("/initOrder")
    //接口请求参数：@RequestParam注解标识，后面跟参数类型和参数名
    public List<UserAddress> initOrder(@RequestParam String userId){
        return service.initOrder(userId);
    }

    @ResponseBody
    @RequestMapping("/getCity")
    public City getCity(@RequestParam String cityId){
        return cityDubboService.findCityById(cityId);
    }
}
