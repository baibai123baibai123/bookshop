package com.baibin.dao.impl;

import com.baibin.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Baibin
 * @Date: 2022/4/15 2:38
 * @Description: TODO
 */
public abstract class BaseDao {
    //使用dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行insert，update，delete等sql操作
     *
     * @param sql
     * @param args
     * @return 如果返回-1，说明执行失败，否则返回影响的行数
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询一个对象数据
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return
     */
    public <T>T queryForOne(String sql,Class<T> type,Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多个对象数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection conn=JdbcUtils.getConnection();
        try {
           return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询一行一列
     * @param sql
     * @param args
     * @return
     */
    public Object querySingleValue(String sql,Object...args){
        Connection conn= JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
