package com.mybatis3.demo.mapper;

import com.mybatis3.demo.domain.Team;

public interface TeamMapperPlus {
    Team selectTeamPluById(Integer teamId);

    Team selectByStep(Integer teamId);
}
