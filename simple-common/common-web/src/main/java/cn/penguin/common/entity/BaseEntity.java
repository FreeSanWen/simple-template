package cn.penguin.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Long id;

    @TableField(exist = false)
    private Integer pageNum;

    @TableField(exist = false)
    private Integer pageSize;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Wrapper<T> wrapper() {
        return new LambdaQueryWrapper();
    }

    public Page<T> startPage() {
        return new Page((long)this.getPageNum(), (long)this.getPageSize());
    }
}
