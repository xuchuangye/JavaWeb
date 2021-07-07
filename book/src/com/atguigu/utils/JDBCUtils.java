package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DruidDataSource dataSource;
    //创建ThreadLocal并关联Connection连接对象
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    static {
        //读取配置文件
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接池中的连接
    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {

            try {
                //如果conn为空，那么从数据库连接池中获取连接对象Connection
                conn = dataSource.getConnection();
                //并使用ThreadLocal进行关联
                conns.set(conn);
                //然后设置手动管理事务
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return conn;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose() {
        //从ThreadLocal中获取关联的数据Connection
        Connection connection = conns.get();
        if (connection != null) {
            try {
                //提交事务
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                //关闭连接
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove移除ThreadLocal的操作，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollBackAndClose() {
        //从ThreadLocal中获取关联的数据Connection
        Connection connection = conns.get();
        if (connection != null) {
            try {
                //回滚事务
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                //关闭连接
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove移除ThreadLocal的操作，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }




    /*//关闭数据库连接
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }*/
}
