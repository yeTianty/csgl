package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 10:58
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean loginUser(String name, String password) {
        String url = "jdbc:mysql://localhost:3306/ty";
        String rootName = "root";
        String rootPassword = "root";
        //这是连接数据库
        Connection connection = null;
        //这是查询数据库
        ResultSet rs = null;
        //这是修改数据库
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, rootName, rootPassword);
            String cs = "select * from student where name='" + name + "' and password='" + password + "'";
            preparedStatement = connection.prepareStatement(cs);
            rs = preparedStatement.executeQuery(cs);
            while (rs.next()) {
                if (rs.getString("name").equals(name) && rs.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int storageUser(String name, String password, String email, String love) {
        String url = "jdbc:mysql://localhost:3306/ty";
        String rootName = "root";
        String rootPassword = "root";
        //链接数据库
        Connection connection = null;
        //查询数据库
        ResultSet rs = null;
        //修改数据库
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, rootName, rootPassword);
            String cs = "select * from student where name = '+name+'";
            preparedStatement = connection.prepareStatement(cs);
            rs = preparedStatement.executeQuery(cs);
            while (rs.next()) {
                if (rs.getString("name").equals(name)) {
                    return 1;
                }
            }
            String sql = "insert student(name, password, email, love) values('" + name + "','" + password + "','" + email + "','" + love + "')";
            PreparedStatement ps = connection.prepareStatement(sql);
            i = ps.executeUpdate();
            if (i > 0) {
                return 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
