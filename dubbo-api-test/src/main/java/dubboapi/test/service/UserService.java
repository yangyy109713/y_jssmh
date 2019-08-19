package dubboapi.test.service;

import dubboapi.test.bean.User;
import dubboapi.test.bean.UserAddress;

import java.util.List;

/**
 * 用户 Dubbo 服务层
 * @author yuanyuanyang
 */
public interface UserService {
    /**
     * 根据用户名称，查询用户信息
     * @return
     */
    User saveUser(User user);


    /**
     * 按照用户id返回所有的收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
