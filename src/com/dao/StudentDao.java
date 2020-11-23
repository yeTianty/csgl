package com.dao;

/**
 * @Author: Tanoty
 * @Date: 2020/11/23 10:56
 */
public interface StudentDao {
    public boolean loginUser(String name, String password);

    public int storageUser(String name, String password, String email, String love);

}
