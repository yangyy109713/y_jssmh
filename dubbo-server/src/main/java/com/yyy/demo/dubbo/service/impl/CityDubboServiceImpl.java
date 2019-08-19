package com.yyy.demo.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import dubboapi.test.bean.City;
import dubboapi.test.service.CityDubboService;
import org.springframework.stereotype.Component;

/**
 * 使用（com.alibaba.dubbo.config.annotation.Service）
 * 不用在.xml中配置对外暴露的服务<dubbo:service...
 */
//对外暴露服务
@Service
@Component
public class CityDubboServiceImpl implements CityDubboService {

    @Override
    public City findCityById(String cityId){
        City city = new City();
        city.setCityName("杭州市");
        city.setId(Long.valueOf(cityId));
        city.setProvinceId(Long.valueOf("001"));
        city.setDescription("zhejianghzejiang");
        System.out.println("1.2 Dubbo server--CityDubboServiceImpl : " + city.toString());
        return city;
    }
}
