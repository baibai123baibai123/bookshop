package com.baibin.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Baibin
 * @Date: 2022/4/15 1:49
 * @Description: TODO
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    static {
        try {
            //读取jdbc配置文件
            InputStream is = com.alibaba.druid.util.JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            Properties properties =new Properties();
            properties.load(is);
            //创建数据库连接池
             dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return 如果返回null说明获取连接失败
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn=dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /***
     * 关闭连接，放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
