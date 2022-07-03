package com.baibin.dao.impl;

import com.baibin.dao.OrderItemDao;
import com.baibin.pojo.OrderItem;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 18:34
 * @Description: TODO
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?);";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
