package com.example.demo.http.api.request;

import com.example.demo.http.ErpBaseHttpRequest;
import com.example.demo.http.ErpBaseHttpResponse;
import com.example.demo.http.api.response.ErpDaoResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/10</p>
 * <p>@Version 1.0</p>
 **/
public class ErpDaoRequest<T> extends ErpBaseHttpRequest {

    @JsonProperty("query")
    private Map<String, Object> query;

    @JsonProperty("sort")
    private Map<String, Object> sort;

    @JsonProperty("pagination")
    private Map<String, Object> pagination;

    public ErpDaoRequest() {}

    public ErpDaoRequest(Map<String, Object> query, Map<String, Object> sort, Map<String, Object> pagination) {
        this.query = query;
        this.sort = sort;
        this.pagination = pagination;
    }

    @Override
    public Class<ErpDaoResponse> getResponseClass() {
        return ErpDaoResponse.class;
    }

    public void setQuery(Map<String, Object> query) {
        this.query = query;
    }

    public void setSort(Map<String, Object> sort) {
        this.sort = sort;
    }

    public void setPagination(Map<String, Object> pagination) {
        this.pagination = pagination;
    }
}
