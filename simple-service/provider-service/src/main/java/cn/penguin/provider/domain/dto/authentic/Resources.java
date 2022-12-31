package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.ResourcesEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.*;

/**
 * @author wensy
 * @since 2022/12/27 9:47
 */
@Data
@TableName("sys_resources")
public class Resources extends ResourcesEntity {

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
