package com.atguigu.dao.impl;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();
    /**
     * update数据库表当中的数据(insert/update/delete)
     * @param sql 执行的sql语句
     * @param args sql语句对应参数的占位符
     * @return 返回-1执行失败，返回其他执行成功
     */
    public int update(String sql, Object ...args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return -1;
    }

    /**
     * 执行sql语句，返回一个对象
     * @param type 哪一个类
     * @param sql 执行的sql语句
     * @param args sql语句对应参数的占位符
     * @param <T> 不知道是哪一个类型，所以使用泛型
     * @return 返回一个对象
     */
    public<T> T selectForOne(Class<T> type, String sql,Object ...args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行sql语句，返回多个对象组成的list集合
     * @param type 哪一个类，对应数据库的哪一张表
     * @param sql 执行的sql语句
     * @param args sql语句对应参数的占位符
     * @param <T> 因为不知道是哪一个类，所以使用泛型
     * @return 返回多个对象的list集合
     */
    public<T> List<T> selectForMany(Class<T> type, String sql, Object ...args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 执行sql语句返回一行一列的数据
     * @param sql 执行的sql语句
     * @param args sql语句对应参数的占位符
     * @return 返回一行一列的数据
     */
    public Object selectForSingleValue(String sql,Object ...args) {
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql, new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
}
