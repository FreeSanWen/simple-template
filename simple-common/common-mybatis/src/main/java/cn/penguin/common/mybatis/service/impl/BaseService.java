package cn.penguin.common.mybatis.service.impl;

import cn.penguin.common.mybatis.entity.BaseEntity;
import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.common.mybatis.service.IBaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author wensy
 * @since 2022-11-28 10:15
 */
public class BaseService<E extends GenericMapper<T>, T extends BaseEntity> implements IBaseService<T> {

    @Autowired
    private E mapper;

    @Override
    public T insert(T record) {
        return mapper.insert(record);
    }

    @Override
    public Boolean deleteById(Serializable id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public Boolean update(T record) {
        return mapper.updateByPrimaryKey(record) > 0;
    }

    @Override
    public T selectById(Serializable id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T selectOne(T query) {
        return mapper.selectOne(query);
    }

    @Override
    public List<T> selectList(T query) {
        return mapper.selectList(query);
    }

    @Override
    public PageInfo<T> selectPage(T query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return new PageInfo<>(mapper.selectList(query));
    }
}
