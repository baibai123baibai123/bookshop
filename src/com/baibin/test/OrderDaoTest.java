package com.baibin.test;

import com.baibin.dao.OrderDao;
import com.baibin.dao.impl.OrderDaoImpl;
import com.baibin.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: Baibin
 * @Date: 2022/5/12 18:49
 * @Description: TODO
 */
public class OrderDaoTest {
    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() throws Exception {
        orderDao.saveOrder(new Order("1234567888777",new Date(),new BigDecimal(1990),0,1));
    }

}