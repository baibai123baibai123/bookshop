package com.baibin.dao;

import com.baibin.pojo.Cart;
import com.baibin.pojo.Order;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 18:26
 * @Description: TODO
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
