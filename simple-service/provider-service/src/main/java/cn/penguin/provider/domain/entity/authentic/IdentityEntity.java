package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022/12/27 9:40
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdentityEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long roleId;

    private Integer isUsed;

    public IdentityEntity(Long id,  Long userId, Long roleId, Integer isUsed, LocalDateTime createTime) {
        super(id);
        this.userId = userId;
        this.roleId = roleId;
        this.isUsed = isUsed;
        this.createTime = createTime;
    }
}
