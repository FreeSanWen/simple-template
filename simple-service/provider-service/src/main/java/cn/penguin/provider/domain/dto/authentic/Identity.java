package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.IdentityEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Data;

/**
 * 用户-角色关联信息表
 *
 * @author wensy
 * @since 2022/12/27 9:42
 */
@Data
@TableName("sys_identity")
public class Identity extends IdentityEntity {

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
