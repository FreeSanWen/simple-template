package cn.penguin.common.entity;

import lombok.Data;

/**
 * @author wensy
 * @since 2022-11-22 11:38:00
 */
@Data
public class LogRecordDTO extends LogRecord {

    /**
     * 条件字段名称
     */
    private String paramCondition;

    /**
     * 结果字段名称
     */
    private String resultCondition;

    /**
     * 1.数组，其他。对象
     */
    private Integer paramType;

    /**
     * 1.数组，其他。对象
     */
    private Integer resultType;

    /**
     * 业务对象主键
     */
    private Long relationId;
}
