package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.provider.domain.entity.authentic.ResourcesEntity;
import lombok.Data;

import java.util.List;

/**
 * @author wensy
 * @since 2022/12/27 9:47
 */
@Data
public class Resources extends ResourcesEntity {

    /**
     * 子集合
     */
    private List<Resources> childList;
}
