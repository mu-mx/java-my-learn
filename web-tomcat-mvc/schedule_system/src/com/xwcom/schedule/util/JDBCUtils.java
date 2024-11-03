package com.xwcom.schedule.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * @Description 操作数据库的工具类
 */
public class JDBCUtils {

    private static DataSource ds;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {// 静态代码块，JDBCToolsVersion1类初始化执行
        try {
            Properties pro = new Properties();
            pro.load(ClassLoader.getSystemResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = tl.get();
        if (connection == null) {// 当前线程还没有拿过连接，就给它从数据库连接池拿一个
            connection = ds.getConnection();
            tl.set(connection);
        }
        return connection;
    }

    public static void free() throws SQLException {
        Connection connection = tl.get();
        if (connection != null) {
            tl.remove();
            connection.setAutoCommit(true);// 避免还给数据库连接池的连接不是自动提交模式（建议）
            connection.close();
        }
    }

}
