package com.example.demo.libraries;

import com.example.demo.core.services.ServiceResponse;
import com.example.demo.core.services.ServiceResponseCode;
import com.example.demo.core.services.ServiceResponseDescription;

/**
 * @auther ttm
 * @date 2017/10/24
 */
public class ServiceResponseHelper {

    private static ServiceResponse response;

    /**
     * 构建返回请求
     * @param code
     * @param description
     * @param result
     * @return
     */
    private static ServiceResponse buildServiceResponse(int code, String description, Object result) {
        response = new ServiceResponse();
        response.setCode(code);
        response.setDescription(description);
        response.setResult(result);
        return response;
    }

    /**
     * 返回成功
     * @param code
     * @param description
     * @param result
     * @return
     */
    private static ServiceResponse success(int code, String description, Object result) {
        return buildServiceResponse(code, description, result);
    }

    /**
     * 返回成功
     * @return
     */
    public static ServiceResponse success() {
        return success(ServiceResponseCode.SUCCESS, ServiceResponseDescription.SUCCESS, null);
    }

    /**
     * 返回成功
     * @param result
     * @return
     */
    public static ServiceResponse success(Object result) {
        return success(ServiceResponseCode.SUCCESS, ServiceResponseDescription.SUCCESS, result);
    }

    /**
     * 服务异常
     * @param code
     * @param description
     * @param result
     * @return
     */
    private static ServiceResponse error(int code, String description, Object result) {
        return buildServiceResponse(code, description, result);
    }

    /**
     * 服务异常
     * @return
     */
    public static ServiceResponse error() {
        return error(ServiceResponseCode.SERVICE_ERROR, ServiceResponseDescription.SERVICE_ERROR, null);
    }

    /**
     * 请求失败
     * @param code
     * @param description
     * @param result
     * @return
     */
    private static ServiceResponse fail(int code, String description, Object result) {
        return buildServiceResponse(code, description, result);
    }

    /**
     * 请求失败
     * @param result
     * @return
     */
    public static ServiceResponse fail(Object result) {
        return fail(ServiceResponseCode.ERROR, ServiceResponseDescription.ERROR, result);
    }

}
