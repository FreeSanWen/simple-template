package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.RoleEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 角色信息表
 *
 * @author wensy
 * @since 2022/12/27 9:36
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_role")
public class Role extends RoleEntity {

    @Builder(toBuilder = true)
    public Role(Long id,String roleCode, String roleName, Integer isEnable, Integer isDelete, LocalDateTime createTime) {
        super(id, roleCode, roleName, isEnable, isDelete, createTime);
    }

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
