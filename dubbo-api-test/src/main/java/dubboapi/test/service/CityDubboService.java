package dubboapi.test.service;


import dubboapi.test.bean.City;

/**
 * 城市业务 Dubbo 服务层
 */
public interface CityDubboService {

    /**
     * 根据城市id，查询城市信息
     * @param cityId
     */
    City findCityById(String cityId);
}
