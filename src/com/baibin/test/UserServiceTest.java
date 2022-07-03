package com.baibin.test;

import com.baibin.pojo.User;
import com.baibin.service.UserService;
import com.baibin.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Baibin
 * @Date: 2022/4/17 2:09
 * @Description: TODO
 */
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void registUser() throws Exception {
        userService.registUser(new User(null,"白aa1","baiaa1","baiaa1@qq.com"));
        userService.registUser(new User(null,"白bb2","baibb2","baibb2@qq.com"));
    }

    @Test
    public void login() throws Exception {
        System.out.println(userService.login(new User(null, "白aa2", "baiaa1", null)));
    }

    @Test
    public void existsUsername() throws Exception {
        System.out.println(userService.existsUsername("白bb2"));
    }

}