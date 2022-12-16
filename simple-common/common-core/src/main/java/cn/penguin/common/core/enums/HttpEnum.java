package cn.penguin.common.core.enums;

import lombok.Getter;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
public enum HttpEnum {

    SUCCESS(200, "Success"),

    FAIL(500, "Internal Server Error"),

    TOKEN_EXPIRED(403, "Token invalid");

    @Getter
    private Integer code;

    @Getter
    private String msg;

    HttpEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
