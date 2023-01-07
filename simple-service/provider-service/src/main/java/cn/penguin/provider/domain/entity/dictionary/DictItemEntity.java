package cn.penguin.provider.domain.entity.dictionary;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统字典类型选项表
 * @TableName sys_dict_item
 */
@Data
public class DictItemEntity extends BaseEntity implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long dictId;

    /**
     * 
     */
    private String itemName;

    /**
     * 
     */
    private String itemValue;

    /**
     * 
     */
    private Integer isDelete;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}