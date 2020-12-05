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
        try {
            mysql();
            String cs = "select * from student where name='" + name + "' and password='" + password + "'";
            ResultSet rs = inquiry(cs);
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
    public List<Student> querySingleData(String name) {
        List<Student> list = new ArrayList<>();
        try {
            mysql();
            ResultSet rs = inquiry("select * from student where name = '" + name + "'");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setEmail(rs.getString("email"));
                student.setLove(rs.getString("love"));
                list.add(student);
            }
            closeMysql();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replaceMemberData(String uData, String data, String name) {
        try {
            mysql();
            int i = modifyDatabase("update student set " + name + " = replace(" + name + ",'" + uData + "','" + data + "')");
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

}
