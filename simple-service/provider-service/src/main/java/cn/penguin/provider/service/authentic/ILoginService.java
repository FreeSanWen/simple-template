package cn.penguin.provider.service.authentic;

import cn.penguin.common.security.entity.LoginUser;

/**
 * @author wensy
 * @since 2022/11/28 21:58
 */
public interface ILoginService {

    String doLogin(LoginUser user);

}
