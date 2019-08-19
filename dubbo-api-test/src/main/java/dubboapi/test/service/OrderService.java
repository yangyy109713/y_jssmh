package dubboapi.test.service;

import dubboapi.test.bean.City;
import dubboapi.test.bean.UserAddress;

import java.util.List;

public interface OrderService {
	
	/**
	 * 初始化订单
	 * @param userId 用户id
	 */
	List<UserAddress> initOrder(String userId);

	City getCity(String cityId);
}
