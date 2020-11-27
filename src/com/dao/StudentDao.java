package com.dao;

import com.daomian.Student;

import java.util.List;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 10:56
 */
public interface StudentDao {

    /**
     * 登录用户
     *
     * @param name     用户名
     * @param password 密码
     * @return 是否登录成功
     */
    public boolean loginUser(String name, String password);

    /**
     * 存储用户
     *
     * @param name     用户名
     * @param password 密码
     * @param email    邮箱
     * @param love     爱好
     * @return 是否添加成功
     */
    public boolean storageUser(String name, String password, String email, String love);

    /**
     * 查询所有用户
     *
     * @return 用户的数组
     */
    List<Student> queryAllUsers();

    /**
     * 删除用户
     *
     * @param name 用户删除
     * @return boolean
     */
    boolean deleteUser(String name);

    /**
     * 查询单个成员数据
     *
     * @param name 用户名
     * @return 返回单个成员数组
     */
    List<Student> querySingleData(String name);

    /**
     * 替换成员数据
     *
     * @param uData 原数据
     * @param data  现有数据
     * @param name  字段名
     * @return 是否替换成功
     */
    boolean replaceMemberData(String uData, String data, String name);

}
