package org.hantiv.redis.util;

import org.apache.commons.lang3.StringUtils;
import org.hantiv.redis.exception.ShareLockException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Zhikun Han
 * @Date Created in 10:59 2022/10/29
 * @Description:
 */
@Component
public class RedisShareLockUtil {

    @Resource
    private RedisUtil redisUtil;

    private Long TIME_OUT = 1000L;

    /**
     * 加锁
     *
     * @param lockKey   锁Key
     * @param requestId 当前锁Id
     * @param time      锁存活时间
     * @return boolean
     */
    public boolean lock(String lockKey, String requestId, Long time) {
        //1.参数校验
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-加锁参数异常");
        }
        long currentTime = System.currentTimeMillis();
        long outTime = currentTime + TIME_OUT;
        Boolean result = false;
        //2.加锁可以自旋（业务冲突小时）
        while (currentTime < outTime) {
            //3.借助redis的setnx进行锁的设置
            result = redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            // set -> expire / lua
            if (result) {
                return result;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTime = System.currentTimeMillis();
        }
        return result;
    }

    /**
     * 解锁
     *
     * @param
     * @return boolean
     */
    public boolean unLock(String key, String requestId) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId)) {
            throw new ShareLockException("分布式锁-解锁-参数异常");
        }
        try {
            String value = redisUtil.get(key);
            if (requestId.equals(value)) {
                return redisUtil.del(key);
            }
        } catch (Exception e) {
            //补日志
        }
        return false;
    }

    /**
     * 尝试加锁
     *
     * @param
     * @return boolean
     */
    public boolean tryLock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-尝试加锁参数异常");
        }
        return redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
    }

}
