package com.example.demo.core.services;

/**
 * 请求返回结果
 * @auther ttm
 * @date 2017/10/11
 */
public class ServiceResponse {

    /**
     * 版本号
     */
    private double version;

    /**
     * 状态码
     */
    private int code;

    /**
     * 描述
     */
    private String description;

    /**
     * 结果集
     */
    private Object result;

    public ServiceResponse() {
        this.version = 1.0;
        this.code = ServiceResponseCode.SUCCESS;
        this.result = null;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
