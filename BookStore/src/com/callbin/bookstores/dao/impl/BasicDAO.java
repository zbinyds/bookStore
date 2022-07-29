package com.callbin.bookstores.dao.impl;

import com.callbin.myssm.util.JDBCutilsDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 张滨
 * @time 2022/07/03 11:04
 * <p>
 * 开发basicDAO，是其他DAO的父类，实现通用的增删改查。其他DAO只需要继承basicDAO即可
 * 使用到Apache-dbutils+druid连接池。
 */

public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();

    //开发通用的 dml 方法, 针对任意的表
    public int update(String sql, Object... params) {
        Connection connect = null;

        try {
            connect = JDBCutilsDruid.getConnect();
            int update = queryRunner.update(connect, sql, params);
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCutilsDruid.close(null, null, connect);
        }

    }

    //返回多个对象(即查询的结果是多行), 针对任意表

    /**
     * @param sql    sql 语句，可以有 ?
     * @param clazz  传入一个类的 Class 对象 比如 Actor.class
     * @param params 传入 ? 的具体的值，可以是多个
     * @return 根据 Actor.class 返回到对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection connect = null;
        List<T> query = null;
        try {
            connect = JDBCutilsDruid.getConnect();
            query = queryRunner.query(connect, sql, new BeanListHandler<>(clazz), params);
            return query;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCutilsDruid.close(null, null, connect);
        }
    }

    //返回单个对象，针对任意表
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        Connection connect = null;

        try {
            connect = JDBCutilsDruid.getConnect();
            T t = queryRunner.query(connect, sql, new BeanHandler<>(clazz), params);
            return t;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCutilsDruid.close(null, null, connect);
        }
    }

    //查询单行单列的方法,即返回单值的方法
    public Object queryScalar(String sql, Object... params) {
        Connection connect = null;

        try {
            connect = JDBCutilsDruid.getConnect();
            Object object = queryRunner.query(connect, sql, new ScalarHandler<>(), params);
            return object;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCutilsDruid.close(null, null, connect);
        }
    }
}
