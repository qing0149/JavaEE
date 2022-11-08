package com.llkj.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DbutilsTools
 * @Description TODO
 * @Author qing
 * @Date 2022/11/6 17:59
 * @Version 1.0
 */
public abstract class DbutilsTools<T> {
    private QueryRunner queryRunner=new QueryRunner();
    /*
    通用的增删改的方法
     */
    protected int update(String sql,Object...args){
        try {
            return queryRunner.update(JDBCUtils.getConnection(),sql,args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    查询单个方法
     */
    protected <T> T getBean(Class<T> clazz, String sql, Object... args){
        List<T> list = getList(clazz, sql, args);
        if(list != null && list.size()>0) {
            return getList(clazz, sql, args).get(0);
        }
        return null;
    }

    /**
     * 通用查询多个对象的方法
     * @param clazz Class 记录对应的类类型
     * @param sql String 查询语句
     * @param args Object... 如果sql中有？，即根据条件查询，可以设置？的值
     * @param <T> 泛型方法声明的泛型类型
     * @return List<T> 把多个对象放到了List集合
     */
    protected <T> List<T> getList(Class<T> clazz, String sql, Object... args){
        try {
            return queryRunner.query(JDBCUtils.getConnection(),sql,new BeanListHandler<T>(clazz),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected Object getValue(String sql,Object... args){
        try {
            return queryRunner.query(JDBCUtils.getConnection(),sql,new ScalarHandler<T>(),args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
