package cn.penguin.common.utils;

import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.constant.SecurityConstant;
import cn.penguin.common.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author wensy
 * @since 2022/12/1 10:45
 */
@Slf4j
public class SecurityUtil {

    /**
     * 根据请求获取用户
     *
     * @param request
     * @return
     */
    public static LoginUser getUser(HttpServletRequest request) {
        return getUser(request, true);
    }

    /**
     * 根据请求获取用户
     *
     * @param request
     * @return
     */
    public static LoginUser getUser(HttpServletRequest request,boolean fresh) {
        String token = getToken(request);
        if (ObjectUtil.isNotEmpty(token)) {
            try {
                String userKey = buildTokenKey(token);
                LoginUser user = RedisUtil.get(userKey);
                if (fresh) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //刷新token有效期
                            refreshToken(user);
                        }
                    }).start();
                }
                return user;
            } catch (Exception e) {
                log.error("{}解析 token 失败。token：{}", LogbackConstant.LOG_PREFIX, token, e);
            }
        }
        return null;
    }

    /**
     * 拼凑 token 的 key
     *
     * @param token
     * @return
     */
    private static String buildTokenKey(String token) {
        return SecurityConstant.LOGIN_TOKEN_KEY + token;
    }

    /**
     * 拼凑 token 的 key
     *
     * @param id
     * @return
     */
    private static String buildUserKey(Long id) {
        return SecurityConstant.LOGIN_USER_KEY + id;
    }

    /**
     * 从 request 的 header 中获取 token
     * @param request
     * @return
     */
    private static String getToken(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstant.AUTHORIZATION);
        if (ObjectUtil.isNotEmpty(token) && token.startsWith(SecurityConstant.TOKEN_PREFIX)) {
            token = token.replace(SecurityConstant.TOKEN_PREFIX, "");
        }
        return token;
    }

    /**
     * 刷新用户过期时间
     *
     * @param user
     */
    private static void refreshToken(LoginUser user) {
        user.setLoginTime(LocalDateUtil.now());
        user.setExpireTime(user.getLoginTime() + SecurityConstant.TOKEN_EXPIRE_TIME_MILL);
        String tokenKey = buildTokenKey(user.getToken());
        String userKey = buildUserKey(user.getId());
        RedisUtil.set(tokenKey, user, SecurityConstant.TOKEN_EXPIRE_TIME, TimeUnit.HOURS);
        RedisUtil.set(userKey, user.getToken(), SecurityConstant.TOKEN_EXPIRE_TIME, TimeUnit.HOURS);
    }

    public static String createToken(LoginUser user) {
        delete(user);
        String token = IdUtil.getIdStr();
        user.setToken(token);
        refreshToken(user);
        return token;
    }

    public static void delete(LoginUser user) {
        if (null != user) {
            Long id = user.getId();
            if (null != id) {
                String userKey = buildUserKey(user.getId());
                String token = RedisUtil.get(userKey);
                String tokenKey = buildTokenKey(token);
                RedisUtil.delete(tokenKey);
                RedisUtil.delete(userKey);
            }
        }
    }

    public static LoginUser getUser() {
        return (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getToken() {
        LoginUser user = getUser();
        if (Objects.nonNull(user)) {
            return user.getToken();
        }
        return "";
    }
}
