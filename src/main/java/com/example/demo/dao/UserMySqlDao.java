package com.example.demo.dao;

import com.example.demo.orm.User;
import com.example.demo.repository.UserMySqlRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther ttm
 * @date 2017/10/16
 */
public interface UserMySqlDao extends JpaRepository<User, Integer>, UserMySqlRepositoryCustom {



}
