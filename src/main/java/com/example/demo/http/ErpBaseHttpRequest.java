package com.example.demo.http;

import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * API 请求参数 基础类
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public abstract class ErpBaseHttpRequest<T> {

    private Long timestamp;
    private Map<String, String> headers;

    public Long getTimestamp() {
        if (null == timestamp) {
            timestamp = System.currentTimeMillis() / 1000;
        }
        return timestamp;
    }

    public abstract Class<T> getResponseClass();

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
