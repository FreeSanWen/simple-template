package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * @author wensy
 * @since 2022/12/27 9:34
 */
@Data
public class RoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String roleCode;

    private String roleName;

    private Integer isEnable;

    private Integer isDelete;

}
