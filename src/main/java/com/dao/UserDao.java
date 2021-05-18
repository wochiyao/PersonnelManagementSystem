package com.dao;

import com.po.User;

import java.util.List;

public interface UserDao {
    User query(User user);
    String queryName(String name);
    List<User> queryAll();
    int insert(User user);
    int update(User user);
    int delete(String name);
}
