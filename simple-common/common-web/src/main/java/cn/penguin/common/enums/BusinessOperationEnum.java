package cn.penguin.common.enums;

import lombok.Getter;

/**
 * @author wensy
 * @since 2022-11-16 16:59:00
 */
public enum BusinessOperationEnum {

    INSERT(1, "insert"),

    DELETE(2, "delete"),

    UPDATE(3, "update");

    @Getter
    private Integer code;

    @Getter
    private String content;

    BusinessOperationEnum(Integer code, String content) {
        this.code = code;
        this.content = content;
    }
}
