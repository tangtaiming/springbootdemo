package com.example.demo.http;

import com.example.demo.http.client.AbstractErpClient;
import com.example.demo.http.client.HttpClientFactory;

/**
 * ERP 请求接口实现
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/10</p>
 * <p>@Version 1.0</p>
 **/
public abstract class ErpHttpClient extends AbstractErpClient {

    public ErpHttpClient(String code) {
        this(code, HttpClientConfig.getDefault());
        System.out.println("Code = " + code);
        setServiceAddress("http://192.168.220.41:8126/");
    }

    public ErpHttpClient(String code, HttpClientConfig config) {
        httpClient = HttpClientFactory.getHttpClient(config);
    }

    @Override
    public <T extends ErpBaseHttpResponse> T syncInvoke(ErpBaseHttpRequest<T> request) throws Exception {
        return syncPost(request, "token");
    }

    @Override
    public void setServiceEntiry(String serviceEntiry) {
        super.setServiceEntiry(serviceEntiry);
    }

    @Override
    public void setServiceAddress(String serviceAddress) {
        super.setServiceAddress(serviceAddress);
    }

}
