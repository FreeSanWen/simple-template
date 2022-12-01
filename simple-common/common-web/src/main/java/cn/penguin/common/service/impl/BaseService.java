package cn.penguin.common.service.impl;

import cn.penguin.common.entity.BaseEntity;
import cn.penguin.common.mapper.BaseMapper;
import cn.penguin.common.service.IBaseService;
import cn.penguin.common.utils.CollectionsUtil;
import cn.penguin.common.utils.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Objects;

/**
 * @author wensy
 * @since 2022-11-28 10:15
 */
public class BaseService<T extends BaseEntity> implements IBaseService<T> {

    private final BaseMapper<T> baseMapper;

    public BaseService(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public T insert(T record) {
        if (Objects.nonNull(record) && Objects.isNull(record.getId())) {
            record.setId(IdUtil.getId());
        }
        baseMapper.insert(record);
        return record;
    }

    @Override
    public T save(T record) {
        if (Objects.nonNull(record) && Objects.isNull(record.getId())) {
            record.setId(IdUtil.getId());
        }
        baseMapper.insertSelective(record);
        return record;
    }

    @Override
    public Boolean insertBatch(List<T> records) {
        if (CollectionsUtil.isNotEmpty(records)) {
            records.stream().forEach(record -> {
                if (Objects.nonNull(record) && Objects.isNull(record.getId())) {
                    record.setId(IdUtil.getId());
                }
            });
        }else{
            return false;
        }
        return baseMapper.insertBatch(records) > 0;
    }

    @Override
    public Boolean deleteById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(T record) {
        return baseMapper.updateById(record) > 0;
    }

    @Override
    public Boolean modify(T record) {
        return baseMapper.updateSelectiveById(record) > 0;
    }

    @Override
    public T selectById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public T selectOne(T query) {
        return baseMapper.selectOne(query);
    }

    @Override
    public List<T> selectList(T query) {
        return baseMapper.selectList(query);
    }

    @Override
    public PageInfo<T> selectPage(T query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        return new PageInfo<>(baseMapper.selectList(query));
    }
}
