package org.hantiv.redis.util;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Author Zhikun Han
 * @Date Created in 19:53 2022/12/2
 * @Description:
 */
@Component
@Slf4j
public class GuavaCacheUtil<K, V> {

    @Resource
    public RedisUtil redisUtil;

    @Value("${guava.cache.switch}")
    public Boolean switchCache;

    private Cache<String, String> localCahce =
            CacheBuilder.newBuilder()
                    .maximumSize(5000)
                    .expireAfterWrite(3, TimeUnit.SECONDS)
                    .build();

    //初始化本地缓存
    public Map<K, V> getResult(List<K> idList, String cacheKeyPrefix, String cacheSuffix, Class<V> clazz,
                               Function<List<K>, Map<K, V>> function){
        if (CollectionUtils.isEmpty(idList)){
            return Collections.emptyMap();
        }
        Map<K, V> resultMap = new HashMap<>(16);
        if (!switchCache){
            resultMap = function.apply(idList);
            return resultMap;
        }
        LinkedList<K> noCacheIdList = new LinkedList<>();
        for(K id : idList){
            String cacheKey = cacheKeyPrefix+"_"+ id+"_"+cacheSuffix;
            String content = localCahce.getIfPresent(cacheKey);
            if (StringUtils.isNoneBlank(content)){
                V v= JSON.parseObject(content, clazz);
                resultMap.put(id, v);
            }else {
                noCacheIdList.add(id);
            }
        }
        if (CollectionUtils.isEmpty(noCacheIdList)){
            return resultMap;
        }
        Map<K, V> noCacheResultMap = function.apply(noCacheIdList);
        if (noCacheResultMap==null || noCacheResultMap.isEmpty()){
            return resultMap;
        }
        for (Map.Entry<K, V> entry: noCacheResultMap.entrySet()){
            K id = entry.getKey();
            V result = entry.getValue();
            resultMap.put(id, result);
            String cacheKey = cacheKeyPrefix+"_"+id+"_"+cacheSuffix;
            localCahce.put(cacheKey,JSON.toJSONString(result));
        }
        return resultMap;
    }
}
