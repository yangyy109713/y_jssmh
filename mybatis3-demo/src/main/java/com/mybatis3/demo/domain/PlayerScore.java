package com.mybatis3.demo.domain;

public class PlayerScore {
    private Integer gameId;

    private Integer playerId;

    private Boolean isFirst;

    private Integer playingTime;

    private Integer rebound;

    private Integer reboundO;

    private Integer reboundD;

    private Integer assist;

    private Integer score;

    private Integer steal;

    private Integer blockshot;

    private Integer fault;

    private Integer foul;

    private Integer shootAttempts;

    private Integer shootHits;

    private Integer shoot3Attempts;

    private Integer shoot3Hits;

    private Integer shootPAttempts;

    private Integer shootPHits;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public Integer getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(Integer playingTime) {
        this.playingTime = playingTime;
    }

    public Integer getRebound() {
        return rebound;
    }

    public void setRebound(Integer rebound) {
        this.rebound = rebound;
    }

    public Integer getReboundO() {
        return reboundO;
    }

    public void setReboundO(Integer reboundO) {
        this.reboundO = reboundO;
    }

    public Integer getReboundD() {
        return reboundD;
    }

    public void setReboundD(Integer reboundD) {
        this.reboundD = reboundD;
    }

    public Integer getAssist() {
        return assist;
    }

    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSteal() {
        return steal;
    }

    public void setSteal(Integer steal) {
        this.steal = steal;
    }

    public Integer getBlockshot() {
        return blockshot;
    }

    public void setBlockshot(Integer blockshot) {
        this.blockshot = blockshot;
    }

    public Integer getFault() {
        return fault;
    }

    public void setFault(Integer fault) {
        this.fault = fault;
    }

    public Integer getFoul() {
        return foul;
    }

    public void setFoul(Integer foul) {
        this.foul = foul;
    }

    public Integer getShootAttempts() {
        return shootAttempts;
    }

    public void setShootAttempts(Integer shootAttempts) {
        this.shootAttempts = shootAttempts;
    }

    public Integer getShootHits() {
        return shootHits;
    }

    public void setShootHits(Integer shootHits) {
        this.shootHits = shootHits;
    }

    public Integer getShoot3Attempts() {
        return shoot3Attempts;
    }

    public void setShoot3Attempts(Integer shoot3Attempts) {
        this.shoot3Attempts = shoot3Attempts;
    }

    public Integer getShoot3Hits() {
        return shoot3Hits;
    }

    public void setShoot3Hits(Integer shoot3Hits) {
        this.shoot3Hits = shoot3Hits;
    }

    public Integer getShootPAttempts() {
        return shootPAttempts;
    }

    public void setShootPAttempts(Integer shootPAttempts) {
        this.shootPAttempts = shootPAttempts;
    }

    public Integer getShootPHits() {
        return shootPHits;
    }

    public void setShootPHits(Integer shootPHits) {
        this.shootPHits = shootPHits;
    }

    @Override
    public String toString() {
        return "PlayerScore{" +
                "gameId=" + gameId +
                ", playerId=" + playerId +
                ", isFirst=" + isFirst +
                ", playingTime=" + playingTime +
                ", rebound=" + rebound +
                ", reboundO=" + reboundO +
                ", reboundD=" + reboundD +
                ", assist=" + assist +
                ", score=" + score +
                ", steal=" + steal +
                ", blockshot=" + blockshot +
                ", fault=" + fault +
                ", foul=" + foul +
                ", shootAttempts=" + shootAttempts +
                ", shootHits=" + shootHits +
                ", shoot3Attempts=" + shoot3Attempts +
                ", shoot3Hits=" + shoot3Hits +
                ", shootPAttempts=" + shootPAttempts +
                ", shootPHits=" + shootPHits +
                '}';
    }
}