package com.example.demo.service.impl;

import com.example.demo.service.TomtopOrderListService;
import org.springframework.stereotype.Service;

/**
 * @auther ttm
 * @date 2017/11/23
 */
@Service
public class TomtopOrderListServiceImpl implements TomtopOrderListService {

//    @Autowired
//    private TomtopOrderListDao orderListDao;
//
//    @Override
//    public boolean tomtopOrderListSave(String orderStr) {
//        TomtopOrderList tomtopOrderList = (TomtopOrderList) JsonHelper.fromJson(orderStr, TomtopOrderList.class);
//        System.out.println("ttm | " + JsonHelper.toJson(tomtopOrderList));
//        orderListDao.save(tomtopOrderList);
//        return tomtopOrderList.getId() == null ? false : true;
//    }
//
//    @Override
//    public TomtopOrderList tomtopOrderListOne(String itemId) {
//        return orderListDao.findTomtopOrderListByCordernumber(itemId);
//    }
}
