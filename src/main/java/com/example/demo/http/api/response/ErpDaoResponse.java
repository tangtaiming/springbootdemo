package com.example.demo.http.api.response;

import com.example.demo.http.ErpBaseHttpResponse;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/10</p>
 * <p>@Version 1.0</p>
 **/
public class ErpDaoResponse<T> extends ErpBaseHttpResponse {

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
