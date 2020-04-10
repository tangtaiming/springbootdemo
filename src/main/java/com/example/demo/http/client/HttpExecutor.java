package com.example.demo.http.client;

import com.example.demo.exception.ErpClientException;
import com.example.demo.http.ClientErrorCode;
import com.example.demo.libraries.ErpCharset;
import com.example.demo.libraries.IOSupport;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public class HttpExecutor {

    protected static final Logger logger = Logger.getLogger(HttpExecutor.class);

    /**
     * 执行请求
     *
     * @param httpUriRequest
     * @return
     * @throws Exception
     */
    protected String syncExecute(CloseableHttpClient httpClient, HttpUriRequest httpUriRequest) throws Exception {
        CloseableHttpResponse httpResponse = null;
        try {
            httpUriRequest.setHeader("Pdd-Sdk-Version","0.0.6");
            httpUriRequest.setHeader("Pdd-Sdk-Type","JAVA");

            httpResponse = httpClient.execute(httpUriRequest);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (!isSuccess(statusCode)) {
                String requestBody = "";
                if (httpUriRequest instanceof HttpPost) {
                    requestBody = EntityUtils.toString(((HttpPost) httpUriRequest).getEntity(), ErpCharset.UTF_8);
                }
                logger.error(String.format("ERROR ! URL : %s ; Header: %s ; requestBody: %s", httpUriRequest.getURI(), printHeader(httpUriRequest.getAllHeaders()), requestBody));
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity) {
                    String responseContent = EntityUtils.toString(entity, ErpCharset.UTF_8);
                    logger.error(String.format("ERROR responseContent :\n %s ", responseContent));
                }
                throw new ErpClientException(ClientErrorCode.HTTP_STATUS_FAIL);
            }
            HttpEntity entity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(entity, ErpCharset.UTF_8);
            EntityUtils.consume(entity);
            return responseContent;
        } finally {
            IOSupport.closeQuietly(httpResponse);
        }
    }

    private String printHeader(Header[] headers) {
        StringBuilder stringBuffer = new StringBuilder("[");
        if (headers != null) {
            for (Header header : headers) {
                stringBuffer.append(header.getName()).append(":").append(header.getValue()).append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /**
     * 响应是否成功
     *
     * @param statusCode
     * @return
     */
    private boolean isSuccess(int statusCode) {
        return (200 <= statusCode && statusCode < 300);
    }


}
