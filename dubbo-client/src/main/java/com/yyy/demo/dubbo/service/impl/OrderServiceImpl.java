package com.yyy.demo.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import dubboapi.test.bean.City;
import dubboapi.test.bean.UserAddress;
import dubboapi.test.service.CityDubboService;
import dubboapi.test.service.OrderService;
import dubboapi.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单消费者：消费用户服务-获取所有收获地址
 */
//@Service
@Component
public class OrderServiceImpl implements OrderService {

    //@Autowired //spring的注解，引用service
    @Reference //远程引用userService服务，自己从注册中心查找
    UserService userService;

    @Reference //远程引用cityDubboService服务，自己从注册中心查找
    CityDubboService cityDubboService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("OrderServiceImpl--userId：" + userId);
        //TODO
        //1.查询用户的收获地址
        List<UserAddress> list = userService.getUserAddressList(userId);
        for (UserAddress userAddress : list){
            System.out.println("用户的收获地址：" + userAddress.getUserAddress());//for test
        }
        return list;
    }

    @Override
    public City getCity(String cityId) {
        return cityDubboService.findCityById("1");
    }
}
