package cn.penguin.provider.common.strategy.impl;

import cn.penguin.common.core.exception.BizException;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.provider.common.strategy.LoginStrategy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Objects;

/**
 * @author wensy
 * @since 2022/12/21 16:48
 */
public class UsernamePasswordLoginStrategy implements LoginStrategy {

    @Override
    public LoginUser check(LoginUser user,AuthenticationManager authenticationManager) {
        //封装校验对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        //使用Manager调用 UserDetailService
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //认证失败，内容为空
        if (Objects.isNull(authentication)){
            throw new BizException("登录失败");
        }
        return (LoginUser) authentication.getPrincipal();
    }
}
