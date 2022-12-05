package cn.penguin.provider.entity.dictionary;

import cn.penguin.common.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * (Dict)实体类
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Data
@Table("sys_dict")
public class DictEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String dictCode;

    private String dictName;

    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
