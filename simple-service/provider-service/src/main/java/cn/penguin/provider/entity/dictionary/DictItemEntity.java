package cn.penguin.provider.entity.dictionary;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * (DictItem)实体类
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Data
public class DictItemEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long dictId;

    private String itemName;

    private String itemValue;

    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
