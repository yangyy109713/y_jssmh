package com.mybatis3.demo.test;

import com.mybatis3.demo.domain.PlayerScore;
import com.mybatis3.demo.domain.PlayerScoreExample;
import com.mybatis3.demo.mapper.PlayerScoreMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisExampleTest {
    @Test
    public void test() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerScoreMapper playerMapper = sqlSession.getMapper(PlayerScoreMapper.class);
            PlayerScoreExample playerScoreExample = new PlayerScoreExample();
            PlayerScoreExample.Criteria criteria = playerScoreExample.createCriteria();
            criteria.andPlayerIdIsNotNull();
            criteria.andPlayerIdBetween(10001,10003);
            criteria.andIsFirstEqualTo(true);

            List<PlayerScore> playerScores = playerMapper.selectByExample(playerScoreExample);
            for (PlayerScore p : playerScores) {
                System.out.println("查询结果："+ p.toString());
            }
        }
    }
}
