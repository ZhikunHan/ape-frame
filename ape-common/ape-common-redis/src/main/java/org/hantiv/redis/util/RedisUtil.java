package org.hantiv.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author Zhikun Han
 * @Date Created in 22:25 2022/10/28
 * @Description:
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

}
