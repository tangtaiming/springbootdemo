package com.example.demo.http.client;

import com.example.demo.http.HttpClientConfig;
import org.apache.http.HttpClientConnection;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/10</p>
 * <p>@Version 1.0</p>
 **/
public class HttpClientFactory {

    /**
     * 构造 HttpClientConnectionManager
     * @return
     */
    public static HttpClientConnectionManager getConnectionManager(int maxTotal, int maxPerRoute) {

        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        SSLContext sslContext;

        try {
            sslContextBuilder.loadTrustMaterial(null, new TrustStrategy() {
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            });
            sslContext = sslContextBuilder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        RegistryBuilder<ConnectionSocketFactory> socketFactoryRegistryBuilder = RegistryBuilder.create();
        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        socketFactoryRegistryBuilder.register("http", new PlainConnectionSocketFactory()).register("https", connectionFactory).build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistryBuilder.build());
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(maxPerRoute);

        return connectionManager;
    }

    /**
     * 获取 HTTP Client
     * @param httpClientConfig
     * @return
     */
    public static CloseableHttpClient getHttpClient(HttpClientConfig httpClientConfig) {
        HttpClientConfig config =httpClientConfig;
        if (null == config) {
            config = HttpClientConfig.getDefault();
        }

        HttpClientBuilder builder = HttpClientBuilder.create();
        RequestConfig defaultConfig = RequestConfig
                .custom()
                .setConnectTimeout(config.getConnectionRequestTimeout())
                .setSocketTimeout(config.getSocketTimeoutMillis())
                .setConnectionRequestTimeout(config.getConnectionRequestTimeout())
                .build();
        builder.setDefaultRequestConfig(defaultConfig);

        HttpClientConnectionManager connectionManager = getConnectionManager(config.getMaxTotal(),config.getDefaultMaxPerRoute());
        builder.setConnectionManager(connectionManager);

        return builder.build();
    }

}
