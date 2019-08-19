package cn.yyy.test;

import cn.yyy.dao.impl.UserDaoMysqlImpl;
import cn.yyy.dao.impl.UserDaoOracleImpl;
import cn.yyy.service.impl.UserServiceImpl;

public class Test1 {
    public static void main(String[] args){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
        System.out.println("---------------------");
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
