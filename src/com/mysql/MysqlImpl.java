package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: Tanoty
 * @Date: 2020/11/25 10:09
 */
public class MysqlImpl implements Mysql {
    String url = "jdbc:mysql://localhost:3306/ty";
    String rootName = "root";
    String rootPassword = "root";
    //链接数据库
    Connection connection = null;
    //查询数据库
    ResultSet rs = null;
    //修改数据库
    PreparedStatement preparedStatement = null;

    @Override
    public void mysql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, rootName, rootPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ResultSet inquiry(String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public void closeMysql() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int modifyMysql(String sql) {
        int q = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            q = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return q;
    }


}
