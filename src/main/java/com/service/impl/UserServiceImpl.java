package com.service.impl;

import com.dao.UserDao;
import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User query(User user) {
        return userDao.query(user);
    }

    @Override
    public String queryName(String name) {
        return userDao.queryName(name);
    }

    @Override
    public int delete(String name) {
        return userDao.delete(name);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

}
