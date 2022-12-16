package cn.penguin.common.core.constant;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
public class SecurityConstant {
    public static final String LOGIN_TOKEN_KEY = "security:token:";

    public static final String LOGIN_USER_KEY = "security:user:";

    public static final String AUTHORIZATION = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final Integer TOKEN_EXPIRE_TIME = 3;

    public static final long TOKEN_EXPIRE_TIME_MILL = 10800000L;
}
