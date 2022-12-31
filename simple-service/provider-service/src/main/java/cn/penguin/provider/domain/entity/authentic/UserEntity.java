package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

/**
 * (User)实体类
 *
 * @author wensy
 * @since 2022-11-26 11:02:58
 */
@Data
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
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
     * 最后更新时间
     */
    private LocalDateTime updateTime;


}

