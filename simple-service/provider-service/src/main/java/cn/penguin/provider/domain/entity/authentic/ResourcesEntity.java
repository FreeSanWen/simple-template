package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * @author wensy
 * @since 2022/12/27 9:44
 */
@Data
public class ResourcesEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String resourcesName;

    private String path;

    private Integer type;

    private Long parentId;

    private Integer module;

}
