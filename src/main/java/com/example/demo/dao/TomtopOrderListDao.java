package com.example.demo.dao;

import com.example.demo.orm.TomtopOrderList;

/**
 * @auther ttm
 * @date 2017/11/23
 */
public interface TomtopOrderListDao {

    public TomtopOrderList findTomtopOrderListByCordernumber(String cordernumber);

}
