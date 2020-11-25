package com.dao;

import com.daomian.Student;
import com.mysql.MysqlImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 10:58
 */
public class StudentDaoImpl extends MysqlImpl implements StudentDao {

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
    public boolean storageUser(String name, String password, String email, String love) {
        try {
            mysql();
            int i = modifyMysql("insert student(name, password, email, love) value ('" + name + "','" + password + "','" + email + "','" + love + "')");
            if (i > 0) {
                closeMysql();
                return true;
            }
            closeMysql();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Student> queryAllUsers() {
        List<Student> sz = new ArrayList<>();
        try {
            mysql();
            ResultSet resultSet = inquiry("select * from student");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setEmail(resultSet.getString("email"));
                student.setLove(resultSet.getString("love"));
                sz.add(student);
            }
            closeMysql();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return sz;
    }

    @Override
    public boolean deleteUser(String name) {
        try {
            mysql();
            int resultSet = modifyMysql("delete from student where name = '" + name + "'");
            if (resultSet > 0) {
                closeMysql();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> chaxun(String name) {
        List<Student> cx = new ArrayList<>();
        try {
            mysql();
            ResultSet resultSet = inquiry("select * from student where name = '" + name + "'");
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPassword(resultSet.getString("password"));
                student.setEmail(resultSet.getString("email"));
                student.setLove(resultSet.getString("love"));
                cx.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cx;
    }
}
