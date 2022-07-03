package com.baibin.service;

import com.baibin.pojo.Cart;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 18:00
 * @Description: TODO
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userid);//返回订单号需要用到
}
