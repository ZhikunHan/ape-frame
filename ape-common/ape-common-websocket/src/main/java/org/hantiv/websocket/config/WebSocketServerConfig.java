package org.hantiv.websocket.config;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhikun Han
 * @Date Created in 21:17 2022/12/2
 * @Description:
 */
@Component
public class WebSocketServerConfig extends ServerEndpointConfig.Configurator {
    @Override
    public boolean checkOrigin(String originHeaderValue){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 校验逻辑
        return true;
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig sec,
                                HandshakeRequest request, HandshakeResponse response){
        Map<String, List<String>> parameterMap = request.getParameterMap();
        List<String> erpList = parameterMap.get("erp");
        if (!CollectionUtils.isEmpty(erpList)){
            sec.getUserProperties().put("erp", erpList.get(0));
        }
    }
}
