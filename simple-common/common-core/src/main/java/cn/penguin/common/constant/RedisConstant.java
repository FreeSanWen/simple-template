package cn.penguin.common.constant;

import java.util.concurrent.TimeUnit;

/**
 * @author wensy
 * @since 2022-11-28 14:21
 */
public class RedisConstant {


    public static final Long LOCK_DEFAULT_TIME = 10L;

    public static final TimeUnit LOCK_DEFAULT_TIME_UNIT = TimeUnit.SECONDS;

    public static final String USER_LOCK = "user_lock";
}
