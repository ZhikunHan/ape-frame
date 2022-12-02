package org.hantiv.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Zhikun Han
 * @Date Created in 22:25 2022/10/28
 * @Description:
 */
@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String CACHE_KEY_SEPARATOR=".";

    /**
     * 构建缓存key
     */
    public String buildKey(String... strObjs){
        return Stream.of(strObjs).collect(Collectors.joining(CACHE_KEY_SEPARATOR));
    }

    /**
     * 是否存在key
     * */
    public boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     */
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    public void set(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public boolean setNx(String key, String value, Long time, TimeUnit timeUnit){
        return redisTemplate.opsForValue().setIfAbsent(key, value, time, timeUnit);
    }

    public String get(String key){
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

}
