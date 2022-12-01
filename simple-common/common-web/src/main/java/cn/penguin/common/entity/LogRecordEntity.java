package cn.penguin.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022-11-22 11:38:00
 */
@Data
public class LogRecordEntity implements Serializable {

    private Long id;

    /**
     * 关联的业务主键
     */
    private Long relationId;

    /**
     * 模块 BusinessModuleEnum
     */
    private Integer module;

    /**
     * 操作 BusinessOperationEnum
     */
    private Integer operationType;

    /**
     * 描述
     */
    private String description;

    /**
     * 1.成功，0.失败
     */
    private Integer isSuccess;

    /**
     * 查询条件，无法确定是对象还是数组，这里用object接受，数据库回自行判断
     */
    private Object params;

    /**
     * 返回结果，同 param
     */
    private Object result;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Long creatorId;

    private String creatorName;
}
