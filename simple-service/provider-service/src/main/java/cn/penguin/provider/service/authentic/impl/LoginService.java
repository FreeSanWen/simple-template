package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.core.exception.BizException;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.common.security.utils.SecurityUtil;
import cn.penguin.provider.common.context.LoginContext;
import cn.penguin.provider.common.enums.LoginEnum;
import cn.penguin.provider.service.authentic.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author wensy
 * @since 2022/11/28 22:00
 */
@Slf4j
@Service
public class LoginService implements ILoginService {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String doLogin(LoginUser user) {
        //调用登录校验策略
        LoginUser loginUser = LoginContext.getInstance(user.getCheckType()).check(user, authenticationManager);
        return SecurityUtil.createToken(loginUser);
    }

}
