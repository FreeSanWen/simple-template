package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户-角色关联信息表
 * @TableName sys_identity
 */
@Data
public class IdentityEntity extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 角色主键
     */
    private Long roleId;

    /**
     * 1.目前使用的角色，0.未使用角色
     */
    private Integer isUsed;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}