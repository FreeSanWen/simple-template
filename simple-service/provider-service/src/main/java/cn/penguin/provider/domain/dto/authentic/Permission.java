package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.PermissionEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.*;

/**
 * @author wensy
 * @since 2022/12/27 9:50
 */
@Data
@TableName("sys_permission")
public class Permission extends PermissionEntity {

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
