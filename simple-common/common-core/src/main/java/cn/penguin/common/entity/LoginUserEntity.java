package cn.penguin.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 当前登录用户
 *
 * @author wensy
 * @since 2022-11-28 17:18
 */
@Data
public class LoginUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 账号
     */
    private String username;

    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 1.锁定，0.禁用
     */
    private Integer isLocked;

    /**
     * 1.启用，0.禁用
     */
    private Integer isEnable;

    /**
     * 1.删除，0.正常
     */
    private Integer isDelete;

    /**
     * 登陆时间
     */
    private long loginTime;

    /**
     * 过期时间
     */
    private long expireTime;

    /**
     * token
     */
    private String token;
}
