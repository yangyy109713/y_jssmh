package com.mybatis3.demo.mapper;

import com.mybatis3.demo.domain.Player;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

public interface PlayerMapperPlus {
    Player selectPlayerUseResultMap(Integer playerId);

    @MapKey("playerName")
    Map<String, Player> selectPlayerTeam(String teamId);

    @MapKey("playerId")
    Map<String, Player> selectPlayerTeam1(String teamId);

    Player selectByStep(Integer playerId);
}
