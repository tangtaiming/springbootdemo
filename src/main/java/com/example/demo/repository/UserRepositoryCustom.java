package com.example.demo.repository;

import java.util.List;
import java.util.Map;

/**
 * 用户自定义注册
 * @auther ttm
 * @date 2017/9/5
 */
public interface UserRepositoryCustom<T> {

    public abstract List<T> userList(Map<String, Object> request);

    public abstract T userOne(Map<String, Object> request);

    public abstract String userNextId();


}
