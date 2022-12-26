package cn.penguin.common.core.enums;

import lombok.Getter;

/**
 * @author wensy
 * @since 2022/12/26 14:09
 */
public enum SystemModuleEnum {

    SYSTEM(10, "系统模块"),
    SYSTEM_AUTHENTIC(1010, "系统-权限模块"),
    SYSTEM_AUTHENTIC_USER(10101, "系统-权限-用户"),
    SYSTEM_AUTHENTIC_ROLE(10102, "系统-权限-角色"),
    SYSTEM_AUTHENTIC_MENU(10103, "系统-权限-菜单"),
    SYSTEM_AUTHENTIC_INTERFACE(10104, "系统-权限-接口"),
    ;

    @Getter
    private Integer code;

    @Getter
    private String msg;

    SystemModuleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
