package com.example.demo.dao;

import com.example.demo.orm.TomtopOrderList;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @auther ttm
 * @date 2017/11/23
 */
public interface TomtopOrderListDao extends MongoRepository<TomtopOrderList, Integer> {

    public TomtopOrderList findTomtopOrderListByCordernumber(String cordernumber);

}
