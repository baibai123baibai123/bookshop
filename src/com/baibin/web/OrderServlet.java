package com.baibin.web;

import com.baibin.pojo.Cart;
import com.baibin.pojo.User;
import com.baibin.service.OrderService;
import com.baibin.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 17:57
 * @Description: TODO
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginuser = (User) req.getSession().getAttribute("loginuser");

        if (loginuser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginuser.getId();
        String orderId = orderService.createOrder(cart, userId);

        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
        System.out.println(req.getContextPath());
    }
}
