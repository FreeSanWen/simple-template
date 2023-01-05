package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;



/**
 * 用户信息表
 *
 * @author wensy
 * @since 2022-11-26 11:02:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 1.锁定，0.正常
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
     * 创建日期
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 创建人姓名
     */
    private String creatorName;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Long updateId;

    /**
     * 更新人姓名
     */
    private String updateName;

    private static final long serialVersionUID = 1L;
}
