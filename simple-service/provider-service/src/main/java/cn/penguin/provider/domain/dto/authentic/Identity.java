package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.IdentityEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 用户-角色关联信息表
 *
 * @author wensy
 * @since 2022/12/27 9:42
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_identity")
public class Identity extends IdentityEntity {

    @Builder(toBuilder = true)
    public Identity(Long id, Long userId, Long roleId, Integer isUsed, LocalDateTime createTime) {
        super(id, userId, roleId, isUsed, createTime);
    }

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
