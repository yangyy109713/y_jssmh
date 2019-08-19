package com.yyy.demo.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import dubboapi.test.bean.User;
import dubboapi.test.bean.UserAddress;
import dubboapi.test.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 用户服务：接口实现
 * @author yuanyuanyang
 */
/**
 * 使用（com.alibaba.dubbo.config.annotation.Service）
 * 不用在.xml中配置对外暴露的服务<dubbo:service...
 */
//对外暴露服务
@Service
@Component
public class UserServiceImpl implements UserService {

    /**
     * 新建用户
     * @param user 用户对象
     * @return 用户对象
     */
    @Override
    public User saveUser(User user){
        user.setId(1);
        System.out.println("2.2 Dubbo server--userServiceImpl : " + user.toString());
        return user;
    }

    /**
     * 按照用户id返回所有收获地址
     * @param userId 用户id
     * @return 收获的地址List
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "杭州市下城区白石巷318号", "1", "yyy", "15168475428", "Y");
        UserAddress address2 = new UserAddress(2, "杭州市下城区城北健身中心11楼", "1", "sxf", "18326605813", "N");
        if(Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(address1, address2);
    }
}
