package com.example.demo.http;

/**
 * ERP API 请求
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public interface ErpClient {

    /**
     * 同步执行请求
     * @param request 请求参数
     * @param <T> 响应类
     * @return 继承与 ErpBaseHttpResponse的响应
     * @throws Exception
     */
    <T extends ErpBaseHttpResponse> T syncInvoke(ErpBaseHttpRequest<T> request) throws Exception;

    /**
     * 销毁实例
     */
    void destroy();

}
