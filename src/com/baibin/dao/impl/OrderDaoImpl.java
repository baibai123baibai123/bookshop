package com.baibin.dao.impl;

import com.baibin.dao.OrderDao;
import com.baibin.pojo.Order;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 18:29
 * @Description: TODO
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{
    @Override
    public int saveOrder(Order order) {
      String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
//        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
