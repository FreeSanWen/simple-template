package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * @author wensy
 * @since 2022/12/27 9:40
 */
@Data
public class IdentityEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long roleId;

    private Integer isUsed;

}
