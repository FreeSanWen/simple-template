package cn.penguin.provider.common.context;

import cn.penguin.provider.common.enums.LoginEnum;
import cn.penguin.provider.common.strategy.LoginStrategy;
import cn.penguin.provider.common.strategy.impl.UsernamePasswordLoginStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wensy
 * @since 2022/12/21 16:47
 */
public class LoginContext {

    private static final Map<Integer, LoginStrategy> loginMap = new HashMap<>();

    static {
        loginMap.put(LoginEnum.USERNAME.getCode(), new UsernamePasswordLoginStrategy());
        loginMap.put(LoginEnum.MOBILE.getCode(), null);
        loginMap.put(LoginEnum.EMAIL.getCode(), null);
        loginMap.put(LoginEnum.QRCODE.getCode(), null);
    }

    public static LoginStrategy getInstance(Integer code){
        if (Objects.isNull(code)) {
            code = LoginEnum.USERNAME.getCode();
        }
        return loginMap.get(code);
    }
}
