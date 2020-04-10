package com.example.demo.http;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * API 返回结果 基础类
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public class ErpBaseHttpResponse {

    @JsonProperty("version")
    private int version;

    @JsonProperty("code")
    private int code;

    @JsonProperty("description")
    private String description;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
