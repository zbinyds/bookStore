package com.callbin.myssm.trans;

import com.callbin.myssm.util.JDBCutilsDruid;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    //开启事务
    public static void beginTrans() throws SQLException {
        JDBCutilsDruid.getConnect().setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws SQLException {
        Connection conn = JDBCutilsDruid.getConnect();
        conn.commit();
        JDBCutilsDruid.close(null,null,conn);
    }

    //回滚事务
    public static void rollback() throws SQLException {
        Connection conn = JDBCutilsDruid.getConnect();
        conn.rollback();
        JDBCutilsDruid.close(null,null,conn);
    }
}
