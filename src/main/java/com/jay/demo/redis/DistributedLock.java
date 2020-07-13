package com.jay.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : DistributedLock
 * @Author :v-ningjianjian.ea
 * @Date : 2020/7/4 9:02
 * @Comments :
 **/
@Component
public class DistributedLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获得锁
     */
    public boolean getLock(String lockId, long millisecond) {
        Boolean success = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",
                millisecond, TimeUnit.MILLISECONDS);
        return success != null && success;
    }

    /**
     * 释放锁
     * @param lockId
     */
    public void releaseLock(String lockId) {
        redisTemplate.delete(lockId);
    }

}