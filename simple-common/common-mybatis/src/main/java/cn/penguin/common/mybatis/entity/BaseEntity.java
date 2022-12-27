package cn.penguin.common.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022-11-30 11:11
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity<T> implements Serializable {

    public Long id;

    public LocalDateTime createTime;

    @TableField(exist = false)
    private Long pageNum;

    @TableField(exist = false)
    private Long pageSize;

    public Wrapper<T> wrapper() {
        return new LambdaQueryWrapper<>();
    }

    public Page<T> startPage() {
        return new Page<>(this.getPageNum(), this.getPageSize());
    }


    public BaseEntity(Long id) {
        this.id = id;
    }
}
