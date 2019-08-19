package com.mybatis3.demo.mapper;

import com.mybatis3.demo.domain.PlayerScore;
import com.mybatis3.demo.domain.PlayerScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayerScoreMapper {
    long countByExample(PlayerScoreExample example);

    int deleteByExample(PlayerScoreExample example);

    int insert(PlayerScore record);

    int insertSelective(PlayerScore record);

    List<PlayerScore> selectByExample(PlayerScoreExample example);

    int updateByExampleSelective(@Param("record") PlayerScore record, @Param("example") PlayerScoreExample example);

    int updateByExample(@Param("record") PlayerScore record, @Param("example") PlayerScoreExample example);
}