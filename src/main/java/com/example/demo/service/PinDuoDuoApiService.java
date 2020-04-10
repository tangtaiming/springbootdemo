package com.example.demo.service;

import com.example.demo.http.ErpBaseHttpRequest;
import com.example.demo.http.ErpBaseHttpResponse;
import com.example.demo.http.ErpHttpClient;
import com.example.demo.http.api.request.ErpDaoRequest;
import com.example.demo.http.api.response.ErpDaoResponse;
import com.example.demo.orm.sale.pinduoduo.PinDuoDuoApiConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/10</p>
 * <p>@Version 1.0</p>
 **/
public class PinDuoDuoApiService extends ErpHttpClient {

    public static final String FETCH_BEAN_LIST = "/pinduoduo/fetchPinDuoDuoApiConfigList";

    public PinDuoDuoApiService() {
        super("PINDUODUO_API");
    }

    public List<PinDuoDuoApiConfig> fetchPinDuoDuoApiConfigList(Map<String, Object> query, Map<String, Object> sort, Map<String, Object> pagination) throws Exception {
        Map<String, Object> queryFlat = query;
        if (null != queryFlat && queryFlat.size() > 1 && queryFlat.containsKey("id")) {
            if (!queryFlat.containsKey("_id")) {
                queryFlat.put("_id", queryFlat.get("id"));
            }
            queryFlat.remove("id");
        }

        ErpDaoRequest<PinDuoDuoApiConfig> request = new ErpDaoRequest(query, sort, pagination);
        setServiceEntiry(FETCH_BEAN_LIST);
        ErpDaoResponse<List<PinDuoDuoApiConfig>> response = (ErpDaoResponse<List<PinDuoDuoApiConfig>>) syncInvoke(request);
        return response.getResult();
    }

}
