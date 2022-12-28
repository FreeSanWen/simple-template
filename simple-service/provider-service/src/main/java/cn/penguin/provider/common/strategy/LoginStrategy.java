package cn.penguin.provider.common.strategy;

import cn.penguin.common.security.entity.LoginUser;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * 登录校验策略
 *
 * @author wensy
 * @since 2022/12/21 16:45
 */
public interface LoginStrategy {

    /**
     * 登录校验
     *
     * @param loginUser 请求对象
     * @param authenticationManager 认证管理器
     * @return 完整用户对象
     */
    LoginUser check(LoginUser loginUser, AuthenticationManager authenticationManager);
}
