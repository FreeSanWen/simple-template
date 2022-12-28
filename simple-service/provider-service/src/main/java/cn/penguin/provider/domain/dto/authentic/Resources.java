package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.ResourcesEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author wensy
 * @since 2022/12/27 9:47
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_resources")
public class Resources extends ResourcesEntity {


    @Builder(toBuilder = true)
    public Resources(Long id,String resourcesName, String path, Integer type, Long parentId, Integer module) {
        super(id, resourcesName, path, type, parentId, module);
    }

    @Override
    public Wrapper wrapper() {
        return super.wrapper();
    }
}
