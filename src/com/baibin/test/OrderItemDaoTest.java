package com.baibin.test;

import com.baibin.dao.OrderItemDao;
import com.baibin.dao.impl.OrderItemDaoImpl;
import com.baibin.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 18:49
 * @Description: TODO
 */
public class OrderItemDaoTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() throws Exception {
        orderItemDao.saveOrderItem(new OrderItem(null,"111",1,new BigDecimal(999),new BigDecimal(999),"1234567888777"));
    }

}