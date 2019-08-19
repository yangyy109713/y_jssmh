package com.mybatis3.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlayerScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Integer value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Integer value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Integer value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Integer value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Integer value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Integer> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Integer> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Integer value1, Integer value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNull() {
            addCriterion("player_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIsNotNull() {
            addCriterion("player_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerIdEqualTo(Integer value) {
            addCriterion("player_id =", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotEqualTo(Integer value) {
            addCriterion("player_id <>", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThan(Integer value) {
            addCriterion("player_id >", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("player_id >=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThan(Integer value) {
            addCriterion("player_id <", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdLessThanOrEqualTo(Integer value) {
            addCriterion("player_id <=", value, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdIn(List<Integer> values) {
            addCriterion("player_id in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotIn(List<Integer> values) {
            addCriterion("player_id not in", values, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdBetween(Integer value1, Integer value2) {
            addCriterion("player_id between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andPlayerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("player_id not between", value1, value2, "playerId");
            return (Criteria) this;
        }

        public Criteria andIsFirstIsNull() {
            addCriterion("is_first is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstIsNotNull() {
            addCriterion("is_first is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstEqualTo(Boolean value) {
            addCriterion("is_first =", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotEqualTo(Boolean value) {
            addCriterion("is_first <>", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstGreaterThan(Boolean value) {
            addCriterion("is_first >", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_first >=", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstLessThan(Boolean value) {
            addCriterion("is_first <", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstLessThanOrEqualTo(Boolean value) {
            addCriterion("is_first <=", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstIn(List<Boolean> values) {
            addCriterion("is_first in", values, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotIn(List<Boolean> values) {
            addCriterion("is_first not in", values, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first between", value1, value2, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_first not between", value1, value2, "isFirst");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeIsNull() {
            addCriterion("playing_time is null");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeIsNotNull() {
            addCriterion("playing_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeEqualTo(Integer value) {
            addCriterion("playing_time =", value, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeNotEqualTo(Integer value) {
            addCriterion("playing_time <>", value, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeGreaterThan(Integer value) {
            addCriterion("playing_time >", value, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("playing_time >=", value, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeLessThan(Integer value) {
            addCriterion("playing_time <", value, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("playing_time <=", value, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeIn(List<Integer> values) {
            addCriterion("playing_time in", values, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeNotIn(List<Integer> values) {
            addCriterion("playing_time not in", values, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeBetween(Integer value1, Integer value2) {
            addCriterion("playing_time between", value1, value2, "playingTime");
            return (Criteria) this;
        }

        public Criteria andPlayingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("playing_time not between", value1, value2, "playingTime");
            return (Criteria) this;
        }

        public Criteria andReboundIsNull() {
            addCriterion("rebound is null");
            return (Criteria) this;
        }

        public Criteria andReboundIsNotNull() {
            addCriterion("rebound is not null");
            return (Criteria) this;
        }

        public Criteria andReboundEqualTo(Integer value) {
            addCriterion("rebound =", value, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundNotEqualTo(Integer value) {
            addCriterion("rebound <>", value, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundGreaterThan(Integer value) {
            addCriterion("rebound >", value, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundGreaterThanOrEqualTo(Integer value) {
            addCriterion("rebound >=", value, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundLessThan(Integer value) {
            addCriterion("rebound <", value, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundLessThanOrEqualTo(Integer value) {
            addCriterion("rebound <=", value, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundIn(List<Integer> values) {
            addCriterion("rebound in", values, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundNotIn(List<Integer> values) {
            addCriterion("rebound not in", values, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundBetween(Integer value1, Integer value2) {
            addCriterion("rebound between", value1, value2, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundNotBetween(Integer value1, Integer value2) {
            addCriterion("rebound not between", value1, value2, "rebound");
            return (Criteria) this;
        }

        public Criteria andReboundOIsNull() {
            addCriterion("rebound_o is null");
            return (Criteria) this;
        }

        public Criteria andReboundOIsNotNull() {
            addCriterion("rebound_o is not null");
            return (Criteria) this;
        }

        public Criteria andReboundOEqualTo(Integer value) {
            addCriterion("rebound_o =", value, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundONotEqualTo(Integer value) {
            addCriterion("rebound_o <>", value, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundOGreaterThan(Integer value) {
            addCriterion("rebound_o >", value, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundOGreaterThanOrEqualTo(Integer value) {
            addCriterion("rebound_o >=", value, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundOLessThan(Integer value) {
            addCriterion("rebound_o <", value, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundOLessThanOrEqualTo(Integer value) {
            addCriterion("rebound_o <=", value, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundOIn(List<Integer> values) {
            addCriterion("rebound_o in", values, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundONotIn(List<Integer> values) {
            addCriterion("rebound_o not in", values, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundOBetween(Integer value1, Integer value2) {
            addCriterion("rebound_o between", value1, value2, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundONotBetween(Integer value1, Integer value2) {
            addCriterion("rebound_o not between", value1, value2, "reboundO");
            return (Criteria) this;
        }

        public Criteria andReboundDIsNull() {
            addCriterion("rebound_d is null");
            return (Criteria) this;
        }

        public Criteria andReboundDIsNotNull() {
            addCriterion("rebound_d is not null");
            return (Criteria) this;
        }

        public Criteria andReboundDEqualTo(Integer value) {
            addCriterion("rebound_d =", value, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDNotEqualTo(Integer value) {
            addCriterion("rebound_d <>", value, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDGreaterThan(Integer value) {
            addCriterion("rebound_d >", value, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDGreaterThanOrEqualTo(Integer value) {
            addCriterion("rebound_d >=", value, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDLessThan(Integer value) {
            addCriterion("rebound_d <", value, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDLessThanOrEqualTo(Integer value) {
            addCriterion("rebound_d <=", value, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDIn(List<Integer> values) {
            addCriterion("rebound_d in", values, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDNotIn(List<Integer> values) {
            addCriterion("rebound_d not in", values, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDBetween(Integer value1, Integer value2) {
            addCriterion("rebound_d between", value1, value2, "reboundD");
            return (Criteria) this;
        }

        public Criteria andReboundDNotBetween(Integer value1, Integer value2) {
            addCriterion("rebound_d not between", value1, value2, "reboundD");
            return (Criteria) this;
        }

        public Criteria andAssistIsNull() {
            addCriterion("assist is null");
            return (Criteria) this;
        }

        public Criteria andAssistIsNotNull() {
            addCriterion("assist is not null");
            return (Criteria) this;
        }

        public Criteria andAssistEqualTo(Integer value) {
            addCriterion("assist =", value, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistNotEqualTo(Integer value) {
            addCriterion("assist <>", value, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistGreaterThan(Integer value) {
            addCriterion("assist >", value, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistGreaterThanOrEqualTo(Integer value) {
            addCriterion("assist >=", value, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistLessThan(Integer value) {
            addCriterion("assist <", value, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistLessThanOrEqualTo(Integer value) {
            addCriterion("assist <=", value, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistIn(List<Integer> values) {
            addCriterion("assist in", values, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistNotIn(List<Integer> values) {
            addCriterion("assist not in", values, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistBetween(Integer value1, Integer value2) {
            addCriterion("assist between", value1, value2, "assist");
            return (Criteria) this;
        }

        public Criteria andAssistNotBetween(Integer value1, Integer value2) {
            addCriterion("assist not between", value1, value2, "assist");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andStealIsNull() {
            addCriterion("steal is null");
            return (Criteria) this;
        }

        public Criteria andStealIsNotNull() {
            addCriterion("steal is not null");
            return (Criteria) this;
        }

        public Criteria andStealEqualTo(Integer value) {
            addCriterion("steal =", value, "steal");
            return (Criteria) this;
        }

        public Criteria andStealNotEqualTo(Integer value) {
            addCriterion("steal <>", value, "steal");
            return (Criteria) this;
        }

        public Criteria andStealGreaterThan(Integer value) {
            addCriterion("steal >", value, "steal");
            return (Criteria) this;
        }

        public Criteria andStealGreaterThanOrEqualTo(Integer value) {
            addCriterion("steal >=", value, "steal");
            return (Criteria) this;
        }

        public Criteria andStealLessThan(Integer value) {
            addCriterion("steal <", value, "steal");
            return (Criteria) this;
        }

        public Criteria andStealLessThanOrEqualTo(Integer value) {
            addCriterion("steal <=", value, "steal");
            return (Criteria) this;
        }

        public Criteria andStealIn(List<Integer> values) {
            addCriterion("steal in", values, "steal");
            return (Criteria) this;
        }

        public Criteria andStealNotIn(List<Integer> values) {
            addCriterion("steal not in", values, "steal");
            return (Criteria) this;
        }

        public Criteria andStealBetween(Integer value1, Integer value2) {
            addCriterion("steal between", value1, value2, "steal");
            return (Criteria) this;
        }

        public Criteria andStealNotBetween(Integer value1, Integer value2) {
            addCriterion("steal not between", value1, value2, "steal");
            return (Criteria) this;
        }

        public Criteria andBlockshotIsNull() {
            addCriterion("blockshot is null");
            return (Criteria) this;
        }

        public Criteria andBlockshotIsNotNull() {
            addCriterion("blockshot is not null");
            return (Criteria) this;
        }

        public Criteria andBlockshotEqualTo(Integer value) {
            addCriterion("blockshot =", value, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotNotEqualTo(Integer value) {
            addCriterion("blockshot <>", value, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotGreaterThan(Integer value) {
            addCriterion("blockshot >", value, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotGreaterThanOrEqualTo(Integer value) {
            addCriterion("blockshot >=", value, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotLessThan(Integer value) {
            addCriterion("blockshot <", value, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotLessThanOrEqualTo(Integer value) {
            addCriterion("blockshot <=", value, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotIn(List<Integer> values) {
            addCriterion("blockshot in", values, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotNotIn(List<Integer> values) {
            addCriterion("blockshot not in", values, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotBetween(Integer value1, Integer value2) {
            addCriterion("blockshot between", value1, value2, "blockshot");
            return (Criteria) this;
        }

        public Criteria andBlockshotNotBetween(Integer value1, Integer value2) {
            addCriterion("blockshot not between", value1, value2, "blockshot");
            return (Criteria) this;
        }

        public Criteria andFaultIsNull() {
            addCriterion("fault is null");
            return (Criteria) this;
        }

        public Criteria andFaultIsNotNull() {
            addCriterion("fault is not null");
            return (Criteria) this;
        }

        public Criteria andFaultEqualTo(Integer value) {
            addCriterion("fault =", value, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultNotEqualTo(Integer value) {
            addCriterion("fault <>", value, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultGreaterThan(Integer value) {
            addCriterion("fault >", value, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("fault >=", value, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultLessThan(Integer value) {
            addCriterion("fault <", value, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultLessThanOrEqualTo(Integer value) {
            addCriterion("fault <=", value, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultIn(List<Integer> values) {
            addCriterion("fault in", values, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultNotIn(List<Integer> values) {
            addCriterion("fault not in", values, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultBetween(Integer value1, Integer value2) {
            addCriterion("fault between", value1, value2, "fault");
            return (Criteria) this;
        }

        public Criteria andFaultNotBetween(Integer value1, Integer value2) {
            addCriterion("fault not between", value1, value2, "fault");
            return (Criteria) this;
        }

        public Criteria andFoulIsNull() {
            addCriterion("foul is null");
            return (Criteria) this;
        }

        public Criteria andFoulIsNotNull() {
            addCriterion("foul is not null");
            return (Criteria) this;
        }

        public Criteria andFoulEqualTo(Integer value) {
            addCriterion("foul =", value, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulNotEqualTo(Integer value) {
            addCriterion("foul <>", value, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulGreaterThan(Integer value) {
            addCriterion("foul >", value, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulGreaterThanOrEqualTo(Integer value) {
            addCriterion("foul >=", value, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulLessThan(Integer value) {
            addCriterion("foul <", value, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulLessThanOrEqualTo(Integer value) {
            addCriterion("foul <=", value, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulIn(List<Integer> values) {
            addCriterion("foul in", values, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulNotIn(List<Integer> values) {
            addCriterion("foul not in", values, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulBetween(Integer value1, Integer value2) {
            addCriterion("foul between", value1, value2, "foul");
            return (Criteria) this;
        }

        public Criteria andFoulNotBetween(Integer value1, Integer value2) {
            addCriterion("foul not between", value1, value2, "foul");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsIsNull() {
            addCriterion("shoot_attempts is null");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsIsNotNull() {
            addCriterion("shoot_attempts is not null");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsEqualTo(Integer value) {
            addCriterion("shoot_attempts =", value, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsNotEqualTo(Integer value) {
            addCriterion("shoot_attempts <>", value, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsGreaterThan(Integer value) {
            addCriterion("shoot_attempts >", value, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_attempts >=", value, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsLessThan(Integer value) {
            addCriterion("shoot_attempts <", value, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_attempts <=", value, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsIn(List<Integer> values) {
            addCriterion("shoot_attempts in", values, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsNotIn(List<Integer> values) {
            addCriterion("shoot_attempts not in", values, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsBetween(Integer value1, Integer value2) {
            addCriterion("shoot_attempts between", value1, value2, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootAttemptsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_attempts not between", value1, value2, "shootAttempts");
            return (Criteria) this;
        }

        public Criteria andShootHitsIsNull() {
            addCriterion("shoot_hits is null");
            return (Criteria) this;
        }

        public Criteria andShootHitsIsNotNull() {
            addCriterion("shoot_hits is not null");
            return (Criteria) this;
        }

        public Criteria andShootHitsEqualTo(Integer value) {
            addCriterion("shoot_hits =", value, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsNotEqualTo(Integer value) {
            addCriterion("shoot_hits <>", value, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsGreaterThan(Integer value) {
            addCriterion("shoot_hits >", value, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_hits >=", value, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsLessThan(Integer value) {
            addCriterion("shoot_hits <", value, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_hits <=", value, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsIn(List<Integer> values) {
            addCriterion("shoot_hits in", values, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsNotIn(List<Integer> values) {
            addCriterion("shoot_hits not in", values, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsBetween(Integer value1, Integer value2) {
            addCriterion("shoot_hits between", value1, value2, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShootHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_hits not between", value1, value2, "shootHits");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsIsNull() {
            addCriterion("shoot_3_attempts is null");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsIsNotNull() {
            addCriterion("shoot_3_attempts is not null");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsEqualTo(Integer value) {
            addCriterion("shoot_3_attempts =", value, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsNotEqualTo(Integer value) {
            addCriterion("shoot_3_attempts <>", value, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsGreaterThan(Integer value) {
            addCriterion("shoot_3_attempts >", value, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_3_attempts >=", value, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsLessThan(Integer value) {
            addCriterion("shoot_3_attempts <", value, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_3_attempts <=", value, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsIn(List<Integer> values) {
            addCriterion("shoot_3_attempts in", values, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsNotIn(List<Integer> values) {
            addCriterion("shoot_3_attempts not in", values, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsBetween(Integer value1, Integer value2) {
            addCriterion("shoot_3_attempts between", value1, value2, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3AttemptsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_3_attempts not between", value1, value2, "shoot3Attempts");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsIsNull() {
            addCriterion("shoot_3_hits is null");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsIsNotNull() {
            addCriterion("shoot_3_hits is not null");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsEqualTo(Integer value) {
            addCriterion("shoot_3_hits =", value, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsNotEqualTo(Integer value) {
            addCriterion("shoot_3_hits <>", value, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsGreaterThan(Integer value) {
            addCriterion("shoot_3_hits >", value, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_3_hits >=", value, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsLessThan(Integer value) {
            addCriterion("shoot_3_hits <", value, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_3_hits <=", value, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsIn(List<Integer> values) {
            addCriterion("shoot_3_hits in", values, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsNotIn(List<Integer> values) {
            addCriterion("shoot_3_hits not in", values, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsBetween(Integer value1, Integer value2) {
            addCriterion("shoot_3_hits between", value1, value2, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShoot3HitsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_3_hits not between", value1, value2, "shoot3Hits");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsIsNull() {
            addCriterion("shoot_p_attempts is null");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsIsNotNull() {
            addCriterion("shoot_p_attempts is not null");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsEqualTo(Integer value) {
            addCriterion("shoot_p_attempts =", value, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsNotEqualTo(Integer value) {
            addCriterion("shoot_p_attempts <>", value, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsGreaterThan(Integer value) {
            addCriterion("shoot_p_attempts >", value, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_p_attempts >=", value, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsLessThan(Integer value) {
            addCriterion("shoot_p_attempts <", value, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_p_attempts <=", value, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsIn(List<Integer> values) {
            addCriterion("shoot_p_attempts in", values, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsNotIn(List<Integer> values) {
            addCriterion("shoot_p_attempts not in", values, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsBetween(Integer value1, Integer value2) {
            addCriterion("shoot_p_attempts between", value1, value2, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPAttemptsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_p_attempts not between", value1, value2, "shootPAttempts");
            return (Criteria) this;
        }

        public Criteria andShootPHitsIsNull() {
            addCriterion("shoot_p_hits is null");
            return (Criteria) this;
        }

        public Criteria andShootPHitsIsNotNull() {
            addCriterion("shoot_p_hits is not null");
            return (Criteria) this;
        }

        public Criteria andShootPHitsEqualTo(Integer value) {
            addCriterion("shoot_p_hits =", value, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsNotEqualTo(Integer value) {
            addCriterion("shoot_p_hits <>", value, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsGreaterThan(Integer value) {
            addCriterion("shoot_p_hits >", value, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoot_p_hits >=", value, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsLessThan(Integer value) {
            addCriterion("shoot_p_hits <", value, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsLessThanOrEqualTo(Integer value) {
            addCriterion("shoot_p_hits <=", value, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsIn(List<Integer> values) {
            addCriterion("shoot_p_hits in", values, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsNotIn(List<Integer> values) {
            addCriterion("shoot_p_hits not in", values, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsBetween(Integer value1, Integer value2) {
            addCriterion("shoot_p_hits between", value1, value2, "shootPHits");
            return (Criteria) this;
        }

        public Criteria andShootPHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("shoot_p_hits not between", value1, value2, "shootPHits");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}