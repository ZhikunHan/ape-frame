package org.hantiv.user.cache;

import org.hantiv.redis.init.AbstractCache;
import org.hantiv.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author Zhikun Han
 * @Date Created in 22:35 2022/10/28
 * @Description:
 */
@Component
public class UserCache extends AbstractCache {

    private static String USER_CACHE_KEY = "USER";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache(){
        //与数据库联动，跟其他数据来源联动
    }

    @Override
    public <T> T getCache(String key) {
        if (!redisTemplate.hasKey(key).booleanValue()){
            reloadCache();
        }
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void clearCache() {
        redisTemplate.delete(USER_CACHE_KEY);
    }

}
