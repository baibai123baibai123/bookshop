package com.baibin.service.impl;

import com.baibin.dao.UserDao;
import com.baibin.dao.impl.UserDaoImpl;
import com.baibin.pojo.User;
import com.baibin.service.UserService;

/**
 * @Author: Baibin
 * @Date: 2022/4/17 2:03
 * @Description: TODO
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserbyUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            //等于null说明没查到，表示可以用
            return false;
        }
        return true;
    }
}
