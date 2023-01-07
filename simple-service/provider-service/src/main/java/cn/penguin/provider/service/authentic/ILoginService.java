package cn.penguin.provider.service.authentic;

import cn.penguin.common.security.entity.LoginUser;

import java.util.Map;

/**
 * @author wensy
 * @since 2022/11/28 21:58
 */
public interface ILoginService {

    Map<String,String> doLogin(LoginUser user);

}
