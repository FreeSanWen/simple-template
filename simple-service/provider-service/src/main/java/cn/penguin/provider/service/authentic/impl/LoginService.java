package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.core.exception.BizException;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.common.security.utils.SecurityUtil;
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
        //封装校验对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        //使用Manager调用 SysUserDetailService
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //认证失败，内容为空
        if (Objects.isNull(authentication)){
            throw new BizException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return SecurityUtil.createToken(loginUser);
    }

}
