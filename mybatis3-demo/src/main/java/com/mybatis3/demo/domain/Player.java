package com.mybatis3.demo.domain;

import org.apache.ibatis.type.Alias;

//@Alias("playyy")//@Alias注解直接给类起别名
public class Player {
    private Integer playerId;

    private Integer teamId;

    private String playerName;

    private Float height;

    private Team team;

    public Player() {
    }

    public Player(Integer playerId, Integer teamId, String playerName, Float height) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.playerName = playerName;
        this.height = height;
    }

    public Player(Integer teamId, String playerName, Float height, Team team) {
        this.teamId = teamId;
        this.playerName = playerName;
        this.height = height;
        this.team = team;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", playerName='" + playerName + '\'' +
                ", height=" + height +
                '}';
    }
}
