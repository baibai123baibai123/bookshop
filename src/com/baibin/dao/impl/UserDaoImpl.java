package com.baibin.dao.impl;

import com.baibin.dao.UserDao;
import com.baibin.pojo.User;

/**
 * @Author: Baibin
 * @Date: 2022/4/15 4:07
 * @Description: TODO
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username=?";
        return queryForOne(sql,User.class,username);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserbyUsernameAndPassword(String username, String password) {
        String sql="select `id`,`username`,`password`,`email` from t_user where username=? and password=?";
        return queryForOne(sql,User.class,username,password);
    }
}
