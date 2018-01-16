package com.example.demo.service.impl;

import com.example.demo.dao.TomtopOrderListDao;
import com.example.demo.libraries.JsonHelper;
import com.example.demo.orm.TomtopOrderList;
import com.example.demo.service.TomtopOrderListService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/11/23
 */
@Service
public class TomtopOrderListServiceImpl implements TomtopOrderListService {

    @Autowired
    private TomtopOrderListDao orderListDao;

    @Override
    public boolean tomtopOrderListSave(String orderStr) {
        TomtopOrderList tomtopOrderList = (TomtopOrderList) JsonHelper.fromJson(orderStr, TomtopOrderList.class);
        System.out.println("ttm | " + JsonHelper.toJson(tomtopOrderList));
        orderListDao.save(tomtopOrderList);
        return tomtopOrderList.getId() == null ? false : true;
    }

    @Override
    public TomtopOrderList tomtopOrderListOne(String itemId) {
        return orderListDao.findTomtopOrderListByCordernumber(itemId);
    }
}
