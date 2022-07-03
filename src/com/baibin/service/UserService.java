package com.baibin.service;

import com.baibin.pojo.User;

/**
 * @Author: Baibin
 * @Date: 2022/4/17 1:50
 * @Description: TODO
 */
public interface UserService {
    /**
     * 注册业务
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录业务
     * @param user
     * @return 返回null代表用户不存在
     */
    public User login(User user);

    /**
     * 判断用户名是否存在业务
     * @param username
     * @return 返回false代表用户名可用,返回true代表已存在不可用
     */
    public boolean existsUsername(String username);
}
