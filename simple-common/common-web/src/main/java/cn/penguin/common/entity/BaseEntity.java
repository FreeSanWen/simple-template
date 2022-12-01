package cn.penguin.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wensy
 * @since 2022-11-30 11:11
 */
@Data
public class BaseEntity implements Serializable {

    private Long id;

    private Integer pageNum;

    private Integer pageSize;
}
