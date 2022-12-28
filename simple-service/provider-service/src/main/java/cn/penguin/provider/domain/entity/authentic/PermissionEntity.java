package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022/12/27 9:49
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long resourcesId;

    public PermissionEntity(Long id,  Long roleId, Long resourcesId) {
        super(id);
        this.roleId = roleId;
        this.resourcesId = resourcesId;
    }
}
