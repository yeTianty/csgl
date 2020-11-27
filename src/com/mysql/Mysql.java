package com.mysql;

import java.sql.ResultSet;

/**
 * @Author: Tanoty
 * @Date: 2020/11/25 10:08
 */
public interface Mysql {
    void mysql();

    /**
     * 查询所有用户
     *
     * @param sql 数据库查询语句
     * @return 返回一个结果集合
     */
    ResultSet inquiry(String sql);

    /**
     * 关闭数据库
     */
    void closeMysql();

    /**
     * 修改数据库
     *
     * @param sql 数据库修改
     * @return int
     */
    int modifyMysql(String sql);

    /**
     * 修改数据库
     *
     * @param sql 数据库查询指令
     * @return 返回1或者0
     */
    int modifyDatabase(String sql);

}
