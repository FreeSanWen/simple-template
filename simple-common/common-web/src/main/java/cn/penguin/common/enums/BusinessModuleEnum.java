package cn.penguin.common.enums;

import lombok.Getter;

/**
 * 前三位代表同一服务，中三位代表同一模块
 * @author wensy
 * @since 2022-11-22 11:38:00
 */
public enum BusinessModuleEnum {
    USER_MODULE(100100100, "User module"),

    ROLE_MODULE(100100200, "Role module"),

    DICT_MODULE(100200100, "Dict module")

    ;

    @Getter
    private Integer code;

    @Getter
    private String content;

    BusinessModuleEnum(Integer code, String content) {
        this.code = code;
        this.content = content;
    }
}
