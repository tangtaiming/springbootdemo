package com.example.demo.service;

import com.example.demo.orm.User;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;

/**
 * 用户业务层
 * @auther ttm
 * @date 2017/10/12
 */
public interface UserService {

    public abstract boolean userSave(Map<String, Object> user);

    public abstract boolean userUpdate(Map<String, Object> user);

    public abstract boolean userDelete(int id);

    public abstract User userOne(Map<String, Object> query);

    public abstract List<User> userList(Map<String, Object> request);

    public abstract Integer userNextId();

}
