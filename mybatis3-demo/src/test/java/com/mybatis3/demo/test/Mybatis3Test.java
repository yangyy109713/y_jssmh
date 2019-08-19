package com.mybatis3.demo.test;

import com.mybatis3.demo.domain.Player;
import com.mybatis3.demo.mapper.PlayerMapper;
import com.mybatis3.demo.mapper.PlayerMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * 1.从XML中构建一个SqlSessionFactory
 * XML为全局配置文件
 * 2.从SqlSessionFactory中获取SqlSession
 * 3.执行SQL语句
 */
public class Mybatis3Test {

    @Test
    public void testAdd() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            System.out.println("mapper.getClass："+ playerMapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = new Player(null, 1003, "魏无羡", Float.valueOf("1.83"));
            int i = playerMapper.addPlayer(player);
            sqlSession.commit();//增删改 需要手动提交，否则会自动回滚
            System.out.println("player主键 playerId="+ player.getPlayerId());
            System.out.println("SQL执行结果："+ i);
        }
    }

    @Test
    public void testUpdate() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            System.out.println("mapper.getClass："+ playerMapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = new Player(10003, 1003, "蓝忘机", Float.valueOf("1.88"));
            int i = playerMapper.updatePlayer(player);
            sqlSession.commit();//增删改 需要手动提交，否则会自动回滚
            System.out.println("SQL执行结果："+ i);
        }
    }

    @Test
    public void testDelete() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            System.out.println("mapper.getClass："+ playerMapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            int i = playerMapper.deletePlayer(1);
            sqlSession.commit();//增删改 需要手动提交，否则会自动回滚
            System.out.println("SQL执行结果："+ i);//若失败/未找到，打印==SQL执行结果：0
        }
    }

    @Test
    public void testUpdateByDynamic() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            System.out.println("mapper.getClass："+ playerMapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = new Player(10001, 1003, "忘机", null);
            int i = playerMapper.updatePlayerByDynamic(player);
            sqlSession.commit();//增删改 需要手动提交，否则会自动回滚
            System.out.println("SQL执行结果："+ i);
        }
    }

}
