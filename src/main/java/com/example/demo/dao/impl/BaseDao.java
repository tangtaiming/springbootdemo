package com.example.demo.dao.impl;

import com.example.demo.repository.UserRepositoryCustom;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @auther ttm
 * @date 2017/10/13
 */
@Component
public abstract class BaseDao<User> implements UserRepositoryCustom<User> {

}
