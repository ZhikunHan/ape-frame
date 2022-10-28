package org.hantiv.redis.init;

import org.springframework.stereotype.Component;

/**
 * @Author Zhikun Han
 * @Date Created in 22:30 2022/10/28
 * @Description:
 */
@Component
public abstract class AbstractCache {

    public void initCache(){}

    public <T> T getCache(String key){
        return null;
    }

    public void clearCache(){}

    public void reloadCache(){
        clearCache();
        initCache();
    }

}
