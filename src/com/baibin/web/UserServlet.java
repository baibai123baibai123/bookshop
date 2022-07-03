package com.baibin.web;

import com.baibin.pojo.User;
import com.baibin.service.UserService;
import com.baibin.service.impl.UserServiceImpl;
import com.baibin.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Author: Baibin
 * @Date: 2022/4/22 22:51
 * @Description: TODO
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    /**
     * 处理登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User loginuser = userService.login(new User(null, username, password, null));
//
//        BeanUtils第三方工具类注入bean方法
        //低级使用
//        User user = new User();
//        WebUtils.copyParmToBean(req.getParameterMap(),user);
//        高级使用
        User user = WebUtils.copyParmToBean(req.getParameterMap(), new User());
//        System.out.println(user);
        User loginuser = userService.login(user);

        if (loginuser == null) {
//            System.out.println("用户名或密码错误");
//            提示密码用户名错误，回显用户名
            req.setAttribute("msg", "用户名或密码错误");
//            req.setAttribute("username", username);
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登陆成功
            //保存cookie信息，回显登陆成功的账号
            Cookie cookie = new Cookie("username", req.getParameter("username"));
            resp.addCookie(cookie);
            //保存用户信息到session域中
            req.getSession().setAttribute("loginuser",loginuser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }


    /**
     * 处理注册
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code=req.getParameter("code");
        if (token!=null&&token.equalsIgnoreCase(code)) {
            //验证码正确
            //判读用户名是否存在
            if (userService.existsUsername(username)) {
                //已存在
                System.out.println("用户名已存在");
//                用户名已存在情况回显信息
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            } else {
                //  不存在,注册成功添加到数据库
                User user = new User(null, username, password, email);
                userService.registUser(user);

                //保存用户信息到session域中
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //验证码不正确返回注册页面
//            System.out.println("验证码不正确");
//            把回显信息保存在request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    /**
     *处理注销业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session域中的信息
        req.getSession().invalidate();
        //重定向到首页
        resp.sendRedirect(req.getContextPath());
    }
}
