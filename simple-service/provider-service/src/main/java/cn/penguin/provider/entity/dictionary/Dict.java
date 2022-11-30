package cn.penguin.provider.entity.dictionary;

import cn.penguin.common.entity.Base;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Dict)实体类
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Data
public class Dict extends Base {
    private static final long serialVersionUID = 1L;

    private String dictCode;

    private String dictName;

    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
