package com.baibin.web;

import com.baibin.pojo.User;
import com.baibin.service.UserService;
import com.baibin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Baibin
 * @Date: 2022/4/19 2:20
 * @Description: TODO
 */
public class TestServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User login = userService.login(new User(null, "白彬", "123456", null));
        req.setAttribute("key1",login);
        req.getRequestDispatcher("/test/test2.jsp").forward(req,resp);
    }
}
