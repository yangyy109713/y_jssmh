package com.mybatis3.demo.mapper;

import com.mybatis3.demo.domain.Team;

public interface TeamMapper {
    Team selectTeamById(Integer teamId);
}
