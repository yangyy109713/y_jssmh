package cn.yyy.service.impl;

import cn.yyy.dao.UserDao;
import cn.yyy.dao.impl.UserDaoMysqlImpl;
import cn.yyy.service.UserService;

public class UserServiceImpl implements UserService {

    /*//如果后期数据库换成了oracle，该处代码需要修改为new UserDaoOracleImpl();
    private UserDao userDao = new UserDaoMysqlImpl();*/

    private UserDao userDao = null;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser(){
        userDao.getUser();
    }
}
