package cn.penguin.provider.domain.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022/12/27 9:44
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourcesEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String resourcesName;

    private String path;

    private Integer type;

    private Long parentId;

    private Integer module;

    public ResourcesEntity(Long id, String resourcesName, String path, Integer type, Long parentId, Integer module) {
        super(id);
        this.resourcesName = resourcesName;
        this.path = path;
        this.type = type;
        this.parentId = parentId;
        this.module = module;
    }
}
