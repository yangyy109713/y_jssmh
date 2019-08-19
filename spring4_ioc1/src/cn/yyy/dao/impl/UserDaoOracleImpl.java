package cn.yyy.dao.impl;

import cn.yyy.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser(){
        System.out.println("oracle获取用户信息...");
    }
}
