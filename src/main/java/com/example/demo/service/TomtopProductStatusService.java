package com.example.demo.service;

import com.example.demo.orm.TomtopProductStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2017/10/16
 */
public interface TomtopProductStatusService {

    public abstract boolean tomtopProductStatusSave(TomtopProductStatus tomtopProductStatus);

    public abstract List<TomtopProductStatus> tomtopProductStatusList();

    /**
     * 构建网站接口数据
     * @return
     */
    public abstract Map<String, Object> tomtopProductFormatList();

}
