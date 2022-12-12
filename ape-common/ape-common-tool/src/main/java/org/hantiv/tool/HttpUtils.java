package org.hantiv.tool;

import javafx.util.Pair;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author Zhikun Han
 * @Date Created in 15:45 2022/12/12
 * @Description: httpclient
 */
public class HttpUtils {

    static CloseableHttpClient httpClient;

    /*
     * http优化
     * 1. 注册registry
     * 2. 注册连接池
     * 3. requestConfig配置
     * 4. httpClient是单例的
     * */
    static {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("http", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(registry);
        clientConnectionManager.setMaxTotal(500);
        clientConnectionManager.setDefaultMaxPerRoute(500);
        clientConnectionManager.setDefaultSocketConfig(
                SocketConfig.custom().setSoTimeout(15, TimeUnit.SECONDS)
                        .setTcpNoDelay(true)
                        .build()
        );
        clientConnectionManager.setValidateAfterInactivity(TimeValue.ofSeconds(15));

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofSeconds(1))
                .setConnectionRequestTimeout(Timeout.ofSeconds(1))
                .setResponseTimeout(Timeout.ofSeconds(1))
                .build();
        httpClient = HttpClients.custom()
                .setConnectionManager(clientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .disableAutomaticRetries()
                .build();
    }

    public static String post(String url, List<Pair<String, String>> pairList,
                              Map<String, String> headerMap) throws Exception {
        url = url + "?" + buildParam(pairList);
        HttpPost httpPost = new HttpPost(url);
        if (Objects.nonNull(headerMap) && headerMap.size()>0){
            headerMap.forEach((key, value)->{
                httpPost.addHeader(key, value);
            });
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        }finally {
            if (null!=response){
                EntityUtils.consume(response.getEntity());
            }
        }

    }

    private static String buildParam(List<Pair<String, String>> pairList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair<String, String> pair : pairList) {
            stringBuilder.append(pair.getKey()).append("=").append(pair.getValue()).append("&");
            // ? name = zhangsan & age = 18
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

}
