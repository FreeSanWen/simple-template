package cn.penguin.common.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * @author wensy
 * @since 2022-11-30 11:11
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity<T> implements Serializable {

    @Id
    public Long id;

    @Transient
    private Integer pageNum;

    @Transient
    private Integer pageSize;

    public BaseEntity(Long id) {
        this.id = id;
    }
}
