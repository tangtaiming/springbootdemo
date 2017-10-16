package com.example.demo.repository;

import com.example.demo.orm.User;

/**
 * @auther ttm
 * @date 2017/10/16
 */
public interface UserMySqlRepositoryCustom {

    public abstract User findUser(String userName, String password);

}
