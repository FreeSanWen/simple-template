package cn.penguin.provider.domain.entity.dictionary;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统字典类型表
 * @TableName sys_dict
 */
@Data
public class DictEntity extends BaseEntity implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String dictCode;

    /**
     * 
     */
    private String dictName;

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