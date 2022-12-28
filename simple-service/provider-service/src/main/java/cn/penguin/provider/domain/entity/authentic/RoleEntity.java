package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022/12/27 9:34
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String roleCode;

    private String roleName;

    private Integer isEnable;

    private Integer isDelete;

    public RoleEntity(Long id, String roleCode, String roleName, Integer isEnable, Integer isDelete, LocalDateTime createTime) {
        super(id);
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.isEnable = isEnable;
        this.isDelete = isDelete;
        this.createTime = createTime;
    }
}
