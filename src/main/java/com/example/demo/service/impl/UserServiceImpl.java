package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserMySqlDao;
import com.example.demo.orm.User;
import com.example.demo.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMySqlDao userMySqlDao;

    @Override
    public boolean userSave(Map<String, Object> user) {
//        User users = (User) JsonHelper.fromJson(JsonHelper.toJson(user), User.class);
//        userDao.save(users);
        return true;
    }

    @Override
    public boolean userUpdate(Map<String, Object> user) {
        return false;
    }

    @Override
    public boolean userDelete(int id) {
        return false;
    }

    @Override
    public User userOne(Map<String, Object> query) {
//        return (User) userDao.userOne(query);
        return null;
    }

    @Override
    public List<User> userList(Map<String, Object> request) {
        return null;
    }

    @Override
    public Integer userNextId() {
        return 0;
    }

    @Override
    public User userOne(int id) {
        return userMySqlDao.findOne(id);
    }

}
