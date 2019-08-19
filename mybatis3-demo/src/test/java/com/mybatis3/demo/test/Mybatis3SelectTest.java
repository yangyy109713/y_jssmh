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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Mybatis3SelectTest {

    @Test
    public void testMaps() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            Map<Integer, Player> map = playerMapper.selectMaps("%03%");
            System.out.println("查询结果：" + map);
        }
    }

    @Test
    public void testMap1() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            Map<String, Object> map = playerMapper.selectMap1(10003);
            System.out.println("查询结果：" + map);
        }
    }

    @Test
    public void testList() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            List<Player> list = playerMapper.selectList("%03%");
            for (Player player : list) {
                System.out.println(player);
            }
        }
    }

    @Test
    public void testSelectByParam() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            Player player = playerMapper.selectByParam(10003, "蓝忘机");
            System.out.println("查询结果：" + player.toString());
        }
    }

    @Test
    public void testSelect1() throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession实例
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//sqlSession.close();//使用完毕，关闭sqlSession
            //方式一：直接执行SQL语句
            String str = "com.mybatis3.demo.mapper.PlayerMapper.selectOne";//=mapper.xml中的namespace + 定义的SQL语句的id值
            Player player = sqlSession.selectOne(str, 10001);
            System.out.println("查询结果：" + player.toString());
            /*
            查询结果：Player{playerId=10001, teamId=null, playerName='韦恩-艾灵顿', height=1.93}
            因为Player.java中定义字段名teamId和表字段team_id不一致，所以查询结果为空
            在sql中设置别名teamId即可
             */
        }
    }

    @Test
    public void testSelect2() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){//等价于sqlSession.close();//使用完毕，关闭sqlSession
            //获取接口的实现类对象
            //会为接口自动创建创建一个代理对象，代理对象执行增删改查方法
            PlayerMapper mapper = sqlSession.getMapper(PlayerMapper.class);//需要保证mapper.xml中命名空间制定为对应接口类
            System.out.println("mapper.getClass："+ mapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = mapper.selectOne(10002);
            System.out.println("查询结果：" + player.toString());
        }
    }

    @Test
    public void testSelect3() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapperAnnotation playerMapperAnnotation = sqlSession.getMapper(PlayerMapperAnnotation.class);
            System.out.println("mapper.getClass："+ playerMapperAnnotation.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = playerMapperAnnotation.selectPlayer(10003);
            System.out.println("查询结果：" + player.toString());
        }
    }

    @Test
    public void testSelectByDynamic() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            System.out.println("mapper.getClass："+ playerMapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = new Player(null, null, "忘机", null);
            //player = playerMapper.selectByDynamic(player);//映射文件中SQL未使用where标签 使用1=1，防止多余的and导致SQL报错
            player = playerMapper.selectByDynamic1(player);//映射文件中SQL使用where标签 去除第一个多余的and
            System.out.println("SQL执行结果："+ player.toString());
        }
    }

    @Test
    public void testSelectByChoose() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            System.out.println("mapper.getClass："+ playerMapper.getClass());//打印结果为 class com.sun.proxy.$Proxy4
            Player player = new Player(null, 1003, null, null);
            List<Player> list = playerMapper.selectByChoose(player);
            System.out.println("SQL执行结果："+ list);
        }
    }

    @Test
    public void testSelectByForeach() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            List<Player> list = playerMapper.selectByForeach(Arrays.asList(10001, 10003, 10044));
            System.out.println("SQL执行结果："+ list);
        }
    }
}
