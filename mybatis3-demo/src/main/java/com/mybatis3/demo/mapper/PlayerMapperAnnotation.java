package com.mybatis3.demo.mapper;

import com.mybatis3.demo.domain.Player;
import org.apache.ibatis.annotations.Select;

public interface PlayerMapperAnnotation {
    /**
     * 注解方式 SQL映射，不推荐使用
     * @param id 接口入参数
     * @return Player对象
     */
    @Select("select * from player where player_id = #{id}")
    Player selectPlayer(Integer id);
}
