package cn.penguin.common.mybatis.service.impl;

import cn.penguin.common.core.utils.IdUtil;
import cn.penguin.common.mybatis.entity.BaseEntity;
import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.common.mybatis.service.IBaseService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author wensy
 * @since 2022-11-28 10:15
 */
public class BaseService<T extends BaseEntity> implements IBaseService<T> {

    private final GenericMapper<T> baseMapper;

    public BaseService(GenericMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public T insert(T record) {
        if (Objects.nonNull(record) && Objects.isNull(record.getId())) {
            record.setId(IdUtil.nextId());
        }
        baseMapper.insert(record);
        return record;
    }

    @Override
    public Boolean deleteById(Serializable id) {
        baseMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(T record) {
        return baseMapper.updateById(record) > 0;
    }

    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public T selectOne(T query) {
        Wrapper<T> wrapper = query.wrapper();
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<T> selectList(T query) {
        Wrapper<T> wrapper = query.wrapper();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public Page<T> selectPage(T query) {
        Wrapper<T> wrapper = query.wrapper();
        Page page = query.startPage();
        return baseMapper.selectPage(page, wrapper);
    }
}
