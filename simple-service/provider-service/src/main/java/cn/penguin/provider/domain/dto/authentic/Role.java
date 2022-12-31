package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.RoleEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Data;

/**
 * 角色信息表
 *
 * @author wensy
 * @since 2022/12/27 9:36
 */
@Data
@TableName("sys_role")
public class Role extends RoleEntity {


    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
