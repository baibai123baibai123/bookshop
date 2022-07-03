package com.baibin.test;

import com.baibin.pojo.Cart;
import com.baibin.pojo.CartItem;
import com.baibin.service.OrderService;
import com.baibin.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 20:56
 * @Description: TODO
 */
public class OrderServiceTest {
    private OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() throws Exception {
        Cart cart= new Cart();

        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(3,"ccb",1,new BigDecimal(50),new BigDecimal(150)));

        System.out.println(orderService.createOrder(cart, 2));
    }

}