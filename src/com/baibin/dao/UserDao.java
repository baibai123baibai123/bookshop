package com.baibin.dao;

import com.baibin.pojo.User;

/**
 * @Author: Baibin
 * @Date: 2022/4/15 3:55
 * @Description: TODO
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @return 返回null说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1操作失败，其他是影响的行数
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public User queryUserbyUsernameAndPassword(String username,String password);
}
