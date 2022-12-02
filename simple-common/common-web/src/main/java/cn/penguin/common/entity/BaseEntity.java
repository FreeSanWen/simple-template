package cn.penguin.common.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author wensy
 * @since 2022-11-30 11:11
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity<T> implements Serializable {

    private Long id;

    private Integer pageNum;

    private Integer pageSize;


}
