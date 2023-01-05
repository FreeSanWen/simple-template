package cn.penguin.common.mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wensy
 * @since 2022-11-30 11:11
 */
@Getter
@Setter
public class BaseEntity<T> implements Serializable {

    private Integer pageNum;

    private Integer pageSize;

}
