package com.baibin.test;

import com.baibin.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author: Baibin
 * @Date: 2022/4/15 2:26
 * @Description: TODO
 */
public class JdbcUtilTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i <100 ; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }

    }
}
