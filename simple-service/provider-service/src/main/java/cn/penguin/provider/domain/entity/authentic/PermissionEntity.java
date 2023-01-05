package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色-资源关联信息表
 * @TableName sys_permission
 */
@Data
public class PermissionEntity extends BaseEntity implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long resourcesId;

    /**
     * 
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}