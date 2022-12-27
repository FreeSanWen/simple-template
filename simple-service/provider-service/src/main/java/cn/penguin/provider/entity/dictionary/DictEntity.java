package cn.penguin.provider.entity.dictionary;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * (Dict)实体类
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Data
public class DictEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String dictCode;

    private String dictName;

    private Integer isDelete;


    private LocalDateTime updateTime;
}
