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
    String url = "jdbc:mysql://39.99.209.230:3306/csgl";
    String rootName = "root";
    String rootPassword = "setusb";
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
            System.out.println("数据库连接出错");
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

    @Override
    public int modifyDatabase(String sql) {
        int i = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("数据库修改模块出错！");
            e.printStackTrace();
        }
        return i;
    }


}
