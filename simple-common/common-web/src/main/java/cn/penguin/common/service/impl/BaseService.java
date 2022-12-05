package cn.penguin.common.service.impl;

import cn.penguin.common.entity.BaseEntity;
import cn.penguin.common.mapper.BaseMapper;
import cn.penguin.common.repository.BaseRepository;
import cn.penguin.common.service.IBaseService;
import cn.penguin.common.utils.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author wensy
 * @since 2022-11-28 10:15
 */
public class BaseService<T extends BaseEntity,ID> implements IBaseService<T,ID> {

    private final BaseMapper<T> baseMapper;
    private final BaseRepository<T, ID> baseRepository;

    public BaseService(BaseMapper<T> baseMapper,BaseRepository<T, ID> baseRepository) {
        this.baseMapper = baseMapper;
        this.baseRepository = baseRepository;
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
        return baseRepository.save(record);
    }

    @Override
    public Boolean saveAll(List<T> records) {
        baseRepository.saveAll(records);
        return true;
    }

    @Override
    public Boolean deleteById(ID id) {
        baseRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(T record) {
        return baseMapper.updateById(record) > 0;
    }

    @Override
    public T selectById(ID id) {
        return baseRepository.findById(id).orElse(null);
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
    public List<T> selectList() {
        return StreamSupport.stream(baseRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public PageInfo<T> selectPage(T query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        return new PageInfo<>(baseMapper.selectList(query));
    }
}
