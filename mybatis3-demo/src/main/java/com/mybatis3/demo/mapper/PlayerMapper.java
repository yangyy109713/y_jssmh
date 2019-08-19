package com.mybatis3.demo.mapper;

import com.mybatis3.demo.domain.Player;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PlayerMapper {

    //@MapKey("playerId") //使用Player对象的主键作为map的key
    @MapKey("playerName") //使用Player对象的playerName作为map的key
    Map<Integer, Player> selectMaps(String teamId);

    Map<String, Object> selectMap1(Integer playerId);

    List<Player> selectList(String teamId);

    Player selectByParam(@Param("playerId") Integer playerId, @Param("playerName") String playerName);

    Player selectOne(Integer playerId);

    int addPlayer(Player player);

    int updatePlayer(Player player);

    int deletePlayer(Integer playerId);

    int updatePlayerByDynamic(Player player);

    Player selectByDynamic(Player player);

    Player selectByDynamic1(Player player);

    List<Player> selectByChoose(Player player);

    List<Player> selectByForeach(@Param("playIdList") List<Integer> ids);
}
