package com.baibin.service.impl;

import com.baibin.dao.OrderDao;
import com.baibin.dao.OrderItemDao;
import com.baibin.dao.impl.OrderDaoImpl;
import com.baibin.dao.impl.OrderItemDaoImpl;
import com.baibin.pojo.Cart;
import com.baibin.pojo.CartItem;
import com.baibin.pojo.Order;
import com.baibin.pojo.OrderItem;
import com.baibin.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 19:24
 * @Description: TODO
 */
public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userid) {
        String orderId=System.currentTimeMillis()+""+userid;
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userid);
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> cartItemEntry : cart.getItems().entrySet()) {
            CartItem cartItem = cartItemEntry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        //清空购物车
        cart.clear();
        //返回订单号
        return orderId;
    }
}
