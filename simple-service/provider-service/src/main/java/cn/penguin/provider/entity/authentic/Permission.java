package cn.penguin.provider.entity.authentic;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author wensy
 * @since 2022/12/27 9:50
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_permission")
public class Permission extends PermissionEntity{

    @Builder(toBuilder = true)
    public Permission(Long id,Long roleId, Long resourcesId) {
        super(id, roleId, resourcesId);
    }

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
