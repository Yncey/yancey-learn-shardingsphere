package com.yancey.learn.core.handler;

import com.yancey.learn.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 *
 * @author yaxuany
 * @date 2019/12/10 下午 4:01
 */
@Component
public class HadoopLockHandler {

    @Resource
    private RedisUtil redis;

    /**
     * 尝试次数的初始值
     */
    private static final int ATTEMPT_NUMBER_INIT_VALUE = 1;
    /**
     * 尝试次数的最大值，当尝试 40 次时，累计等待时间为 501.8 秒
     */
    private static final int ATTEMPT_NUMBER_MAX_VALUE = 40;
    /**
     * 等待时间的基数：10 毫秒
     */
    private static final int WAIT_TIME_BASIC_VALUE = 10;
    /**
     * 等待时间的最大值：20 秒
     */
    private static final int WAIT_TIME_MAX_VALUE = 20 * 1000;

    private static final Logger logger = LoggerFactory.getLogger(HadoopLockHandler.class);

    /**
     * 获取定时任务锁
     *
     * @param lockName
     * @param lockExpireTime
     * @return boolean
     */
    private boolean tryLock(String lockName, int lockExpireTime) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");
        boolean isAcquired = false;
        try {
            int lockResult = redis.setnx(lockName, LocalDateTime.now().toString());
            if (lockResult == 1) {
                if (redis.expire(lockName, lockExpireTime)) {
                    isAcquired = true;
                } else {
                    throw new Exception("set expire failed!");
                }
            }
        } catch (Exception e) {
            logger.warn("lock failed!lockName:{},errorMsg:{}", lockName, e.getMessage());
            this.releaseLock(lockName);
        }
        if (isAcquired) {
            return true;
        }
        logger.info("Lock '{}' was existing.", lockName);
        return false;
    }

    /**
     * 获取定时任务锁，过期时间按 秒 计
     *
     * @param lockName
     * @param lockExpireTime
     * @return boolean
     */
    public boolean tryLockBySeconds(String lockName, int lockExpireTime) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");

        return tryLock(lockName, lockExpireTime);
    }

    /**
     * 获取定时任务锁，直到成功为止
     *
     * @param lockName
     * @param lockExpireTime
     * @return boolean
     */
    private boolean tryLockUntilSuccess(String lockName, int lockExpireTime) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");

        return tryLockUntilSuccess(lockName, lockExpireTime, ATTEMPT_NUMBER_INIT_VALUE);
    }

    /**
     * 获取定时任务锁，直到成功为止，过期时间按 秒 计
     *
     * @param lockName
     * @param lockExpireTime
     * @return boolean
     */
    public boolean tryLockUntilSuccessBySeconds(String lockName, int lockExpireTime) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");

        return tryLockUntilSuccess(lockName, lockExpireTime);
    }


    /**
     * 延长任务锁
     *
     * @param lockName
     * @param lockExpireTime
     * @return boolean
     */
    private boolean expireLock(String lockName, int lockExpireTime) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");

        return redis.expire(lockName, lockExpireTime);
    }

    /**
     * 延长任务锁，过期时间按 秒 计
     *
     * @param lockName
     * @param lockExpireTime
     * @return boolean
     */
    public boolean expireLockBySeconds(String lockName, int lockExpireTime) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");

        return expireLock(lockName, lockExpireTime);
    }

    /**
     * 获取任务锁的过期时间
     *
     * @param lockName
     * @return long
     */
    private long getExpire(String lockName) {
        Assert.hasText(lockName, "lockName must not be blank.");

        return redis.ttl(lockName);
    }

    /**
     * 获取任务锁的过期时间，过期时间按 秒 计
     *
     * @param lockName
     * @return long
     */
    public long getExpireBySeconds(String lockName) {
        Assert.hasText(lockName, "lockName must not be blank.");

        return getExpire(lockName);
    }

    /**
     * 释放锁
     *
     * @param lockName
     */
    public void releaseLock(String lockName) {
        Assert.hasText(lockName, "lockName must not be blank.");
        if (StringUtils.isNotBlank(lockName)) {
            redis.del(lockName);
        }
    }

    /**
     * 判断锁是否存在
     *
     * @param lockName
     * @return boolean
     */
    public boolean existLock(String lockName) {
        Assert.hasText(lockName, "lockName must not be blank.");
        return redis.exists(lockName);
    }

    /**
     * 获取定时任务锁，直到成功为止
     *
     * @param lockName
     * @param lockExpireTime
     * @param attemptNumber
     * @return boolean
     */
    private boolean tryLockUntilSuccess(String lockName, int lockExpireTime, int attemptNumber) {
        Assert.hasText(lockName, "lockName must not be blank.");
        Assert.isTrue(lockExpireTime > 0, "lockExpireTime must be greater than 0.");
        Assert.isTrue(attemptNumber > 0, "attemptNumber must be greater than 0.");

        if (tryLock(lockName, lockExpireTime)) {
            return true;
        }
        //exceed limit
        if (attemptNumber >= ATTEMPT_NUMBER_MAX_VALUE) {
            logger.error("After {} attempts, try lock '{}' still failed.", attemptNumber, lockName);
            return false;
        }
        //wait
        long waitTime = computeWaitTime(attemptNumber);
        try {
            TimeUnit.MILLISECONDS.sleep(waitTime);
        } catch (InterruptedException e) {
            logger.warn("InterruptedException occurred.", e);
        }
        //retry
        return tryLockUntilSuccess(lockName, lockExpireTime, ++attemptNumber);
    }

    /**
     * 计算等待时间
     *
     * @param attemptNumber
     * @return long
     */
    private long computeWaitTime(int attemptNumber) {
        Assert.isTrue(attemptNumber > 0, "attemptNumber must be greater than 0.");

        long fibonacciNumber = computeFibonacciNumber(attemptNumber);
        long time = WAIT_TIME_BASIC_VALUE * fibonacciNumber;
        return time < WAIT_TIME_MAX_VALUE ? time : WAIT_TIME_MAX_VALUE;
    }

    /**
     * 计算斐波那契数列的第 n 个数
     *
     * @param n
     * @return long
     */
    private long computeFibonacciNumber(long n) {
        if (n == 0L) {
            return 0L;
        }
        if (n == 1L) {
            return 1L;
        }

        long prevPrev = 0L;
        long prev = 1L;
        long result = 0L;
        for (long i = 2L; i <= n; i++) {
            result = prev + prevPrev;
            prevPrev = prev;
            prev = result;
        }
        return result;
    }

}