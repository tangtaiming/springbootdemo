package com.example.demo.http.client;

import com.example.demo.exception.ErpClientException;
import com.example.demo.http.ClientErrorCode;
import com.example.demo.http.ErpBaseHttpRequest;
import com.example.demo.http.ErpBaseHttpResponse;
import com.example.demo.http.ErpClient;
import com.example.demo.libraries.IOSupport;
import com.example.demo.libraries.JsonUtil;
import com.qiniu.util.Json;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public abstract class AbstractErpClient extends HttpExecutor implements ErpClient {

    private String serviceAddress;

    private String serviceEntiry;

    /**
     * httpClient客户端实例
     */
    protected CloseableHttpClient httpClient;

    protected <T extends ErpBaseHttpResponse> T syncPost(ErpBaseHttpRequest<T> request, String serviceToken) throws Exception {
        String requestUrl = StringUtils.stripEnd(serviceAddress, "/") + StringUtils.stripEnd(serviceEntiry, "/") + "?token=" + serviceToken;
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + requestUrl);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^lion " + Json.encode(request));
        HttpPost httpPost = new HttpPost(requestUrl);
        if (!CollectionUtils.isEmpty(request.getHeaders())) {
            request.getHeaders().entrySet();
            for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }

        String responseContent = syncExecute(httpClient, httpPost);
        return JsonUtil.transferToObj(responseContent, request.getResponseClass());
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServiceEntiry() {
        return serviceEntiry;
    }

    public void setServiceEntiry(String serviceEntiry) {
        this.serviceEntiry = serviceEntiry;
    }

    @Override
    public void destroy() {
        try {
            if (httpClient != null) {
                httpClient.close();
                logger.debug("PopClient destroy success");
            }
        } catch (IOException e) {
            logger.debug("PopClient destroy fail");
            throw new ErpClientException(ClientErrorCode.DESTROY_CLIENT_ERROR);
        } finally {
            IOSupport.closeQuietly(httpClient);
        }
    }
}
