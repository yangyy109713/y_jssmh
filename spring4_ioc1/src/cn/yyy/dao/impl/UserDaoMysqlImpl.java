package cn.yyy.dao.impl;

import cn.yyy.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser(){
        System.out.println("mysql获取用户信息...");
    }
}
