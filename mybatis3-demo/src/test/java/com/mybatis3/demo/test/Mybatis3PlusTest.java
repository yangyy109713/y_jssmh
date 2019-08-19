package com.mybatis3.demo.test;

import com.mybatis3.demo.domain.Player;
import com.mybatis3.demo.domain.Team;
import com.mybatis3.demo.mapper.PlayerMapperPlus;
import com.mybatis3.demo.mapper.TeamMapper;
import com.mybatis3.demo.mapper.TeamMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

public class Mybatis3PlusTest {

    @Test
    public void test1() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapperPlus mapperPlus = sqlSession.getMapper(PlayerMapperPlus.class);
            Player player = mapperPlus.selectPlayerUseResultMap(10003);
            System.out.println("查询结果：" + player);
        }
    }

    @Test
    public void test2() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapperPlus mapperPlus = sqlSession.getMapper(PlayerMapperPlus.class);
            Map<String, Player> playerMap = mapperPlus.selectPlayerTeam("%03%");
            System.out.println("查询结果：" + playerMap);
        }
    }

    @Test
    public void test3() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapperPlus mapperPlus = sqlSession.getMapper(PlayerMapperPlus.class);
            Map<String, Player> playerMap = mapperPlus.selectPlayerTeam1("%03%");
            System.out.println("查询结果：" + playerMap);
        }
    }

    @Test
    public void test4() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapperPlus mapperPlus = sqlSession.getMapper(PlayerMapperPlus.class);
            Player player = mapperPlus.selectByStep(10044);
            System.out.println("查询结果：" + player.getPlayerName());
        }
    }

    @Test
    public void testCollectPlus() throws Exception {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            TeamMapperPlus teamMapper = sqlSession.getMapper(TeamMapperPlus.class);
            Team team = teamMapper.selectTeamPluById(1003);
            System.out.println("selectTeamPluById查询结果1：" + team);
            System.out.println("selectTeamPluById查询结果2：" + team.getPlayerList());
        }
    }

    @Test
    public void testCollectPlus2() throws Exception {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            TeamMapperPlus teamMapper = sqlSession.getMapper(TeamMapperPlus.class);
            Team team = teamMapper.selectByStep(1003);
            System.out.println("selectByStep查询结果1：" + team);
            System.out.println("selectByStep查询结果2：" + team.getPlayerList());
        }
    }
}
