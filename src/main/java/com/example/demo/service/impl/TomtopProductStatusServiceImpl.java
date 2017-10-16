package com.example.demo.service.impl;

import com.example.demo.dao.TomtopProductStatusDao;
import com.example.demo.libraries.JsonHelper;
import com.example.demo.orm.TomtopProductStatus;
import com.example.demo.service.TomtopProductStatusService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/16
 */
@Service
public class TomtopProductStatusServiceImpl implements TomtopProductStatusService {

    @Autowired
    private TomtopProductStatusDao tomtopProductStatusDao;

    @Override
    public boolean tomtopProductStatusSave(TomtopProductStatus tomtopProductStatus) {
        tomtopProductStatusDao.save(tomtopProductStatus);
        return tomtopProductStatus.getId() > 0 ? true : false;
    }

    @Override
    public List<TomtopProductStatus> tomtopProductStatusList() {
        return tomtopProductStatusDao.findAll();
    }

    /**
     * 构建网站接口数据
     *
     * @return
     */
    @Override
    public Map<String, Object> tomtopProductFormatList() {
        Map<String, Object> statusMap = new HashMap<String, Object>();
        List<Map<String, Object>> datas = new ArrayList<>();
        List<TomtopProductStatus> tomtopProductStatuses = tomtopProductStatusList();
        if (CollectionUtils.isNotEmpty(tomtopProductStatuses)) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("id", 113);
            dataMap.put("languageId", 1);
            dataMap.put("type", "PRODUCT_STATUS");
            dataMap.put("value", JsonHelper.toJson(tomtopProductStatuses));
            dataMap.put("name", "productStatus");
            datas.add(dataMap);
            statusMap.put("ret", 1);
            statusMap.put("data", datas);
            return statusMap;
        }

        return null;
    }

}
