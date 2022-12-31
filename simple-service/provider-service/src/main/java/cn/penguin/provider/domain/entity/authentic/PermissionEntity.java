package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * @author wensy
 * @since 2022/12/27 9:49
 */
@Data
public class PermissionEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long resourcesId;

}
