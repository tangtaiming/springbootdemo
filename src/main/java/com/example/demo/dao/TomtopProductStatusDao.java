package com.example.demo.dao;

import com.example.demo.orm.TomtopProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther ttm
 * @date 2017/10/16
 */
@Repository
public interface TomtopProductStatusDao extends JpaRepository<TomtopProductStatus, Integer> {

}
