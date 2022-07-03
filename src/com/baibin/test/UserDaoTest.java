package com.baibin.test;


import com.baibin.dao.UserDao;
import com.baibin.dao.impl.UserDaoImpl;
import com.baibin.pojo.User;
import org.junit.Test;

/**
 * @Author: Baibin
 * @Date: 2022/4/15 4:19
 * @Description: TODO
 */

public class UserDaoTest {
    @Test
    public void queryUserByUsername() throws Exception {
        UserDao userDao =new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
        if (userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() throws Exception {
        UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.saveUser(new User(null, "admin1", "123456", "baibin@qq.com")));

    }

    @Test
    public void queryUserbyUsernameAndPassword() throws Exception {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserbyUsernameAndPassword("admin","admin"));
        if (userDao.queryUserbyUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误，登陆失败");
        }else {
            System.out.println("查询陈功");
        }
    }



}
