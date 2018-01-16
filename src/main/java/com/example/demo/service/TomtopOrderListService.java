package com.example.demo.service;

import com.example.demo.orm.TomtopOrderList;

/**
 * @auther ttm
 * @date 2017/11/23
 */
public interface TomtopOrderListService {

    public boolean tomtopOrderListSave(String orderStr);

    public TomtopOrderList tomtopOrderListOne(String itemId);

}
