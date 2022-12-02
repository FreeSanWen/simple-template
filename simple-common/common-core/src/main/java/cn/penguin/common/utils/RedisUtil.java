package cn.penguin.common.utils;

import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.constant.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Slf4j
@DependsOn("springUtil")
public class RedisUtil {

    private static final RedisTemplate redisTemplate = SpringUtil.getBean("redisTemplate");

    public static RedisTemplate getInstance() {
        return redisTemplate;
    }

    /**
     * 判断是否包含 key
     *
     * @param key
     * @return boolean
     */
    public static boolean containsKey(String key) {
        try {
            if (ObjectUtils.isEmpty(key)) {
                return false;
            }
            Boolean result = redisTemplate.hasKey(key);
            return null == result ? false : result;
        } catch (Exception e) {
            log.error("redis 获取 key：{} 失败", key, e);
        }
        return false;
    }

    /**
     * 根据 key 获取 value
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        if (containsKey(key)) {
            ValueOperations<String, T> operations = redisTemplate.opsForValue();
            return operations.get(key);
        }
        return null;
    }

    /**
     * 普通缓存存储,并设置过期时间和时间单位
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value, long expireTime, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, expireTime, timeUnit);
    }

    /**
     * 普通缓存删除
     *
     * @param key
     * @return boolean
     */
    public static boolean delete(String key) {
        if (containsKey(key)) {
            redisTemplate.delete(key);
        }
        return false;
    }

    /**
     * 操作hash
     *
     * @return
     */
    public static HashOperations hash() {
        return redisTemplate.opsForHash();
    }

    /**
     * 管道操作
     *
     * @return
     */
    public static Object executePipelined(SessionCallback<Object> callback) {
        return RedisUtil.getInstance().executePipelined(callback);
    }

    /**
     * 加锁，带默认过期时间
     *
     * @param key
     * @param value
     * @return
     */
    public static Boolean lock(String key, Long value) {
        return getInstance().opsForValue().setIfAbsent(key, value, RedisConstant.LOCK_DEFAULT_TIME, RedisConstant.LOCK_DEFAULT_TIME_UNIT);
    }

    /**
     * 加锁
     *
     * @param key
     * @param value    保证是加锁的线程
     * @param time     过期时间
     * @param timeUnit 过期时间单位
     * @return
     */
    public static Boolean lock(String key, Long value, Long time, TimeUnit timeUnit) {
        return getInstance().opsForValue().setIfAbsent(key, value, time, timeUnit);
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public static void releaseLock(String key, Long value) {
        String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then return redis.call(\"del\",KEYS[1]) else return 0 end";
        RedisUtil.getInstance().execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList(key), value);
    }

    /**
     * 简单的加锁模板方法
     *
     * @param key      加锁的key
     * @param function 执行的具体业务逻辑
     * @param param    入参
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> R lock(String key, Function<T, R> function, T param) {
        Long id = IdUtil.getId();
        Boolean lock = RedisUtil.lock(key, id);
        if (lock) {
            log.info("{}获得锁", LogbackConstant.LOG_PREFIX);
            try {
                //加锁成功，执行具体逻辑
                return function.apply(param);
            } finally {
                //解锁
                RedisUtil.releaseLock(key, id);
            }
        } else {
            log.info("{}获取锁失败", LogbackConstant.LOG_PREFIX);
            //这里可以选择重试
        }
        return null;
    }


}
