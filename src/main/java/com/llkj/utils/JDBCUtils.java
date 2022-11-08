package com.llkj.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName JDBCTools
 * @Description TODO
 * @Author qing
 * @Date 2022/11/6 16:55
 * @Version 1.0
 */
public class JDBCUtils {
    //连接数据库
    private static DataSource ds;
    //静态变量的初始化，可以使用静态代码块
    static{
        Properties pro = new Properties();

        try {
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("application.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //Connection表示ThreadLocalMap中（key value）的value是Connection类型的对象
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection==null){
            connection = ds.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    public static void freeConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection!=null){
            connection.setAutoCommit(true);//设置成自动提交
            threadLocal.remove();//从当前线程的ThreadLocalMap中删除这个连接
            connection.close();
        }
    }


}
