package cn.penguin.provider.common.enums;

import lombok.Getter;

/**
 * @author wensy
 * @since 2022/12/21 16:50
 */
public enum LoginEnum {

    USERNAME(1, "用户名登录"),

    MOBILE(2, "手机登录"),

    EMAIL(3, "邮箱登录"),

    QRCODE(4, "二维码登录");

    @Getter
    private Integer code;

    @Getter
    private String msg;

    LoginEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
