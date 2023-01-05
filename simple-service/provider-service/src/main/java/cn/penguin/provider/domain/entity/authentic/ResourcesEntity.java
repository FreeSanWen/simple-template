package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源信息表
 * @TableName sys_resources
 */
@Data
public class ResourcesEntity extends BaseEntity implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 资源名称
     */
    private String resourcesName;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 1.菜单，2.接口
     */
    private Integer type;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 模块类型，参考SystemModuleEnum
     */
    private Integer module;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}