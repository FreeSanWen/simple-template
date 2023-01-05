package cn.penguin.common.mybatis.mapper;


import cn.penguin.common.mybatis.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wensy
 * @since 2022/12/6 13:57
 */
public interface GenericMapper<T extends BaseEntity> {

    /**
     * 插入
     *
     * @param entity
     * @return
     */
    T insert(T entity);

    /**
     * 选择性插入
     *
     * @param entity
     * @return
     */
    T insertSelective(T entity);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Serializable id);

    /**
     * 删除
     *
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 非空更新
     *
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

    /**
     * 全部更新
     *
     * @param entity
     * @return
     */
    T updateByPrimaryKeySelective(T entity);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    T selectByPrimaryKey(Serializable id);

    /**
     * 查询
     *
     * @param query
     * @return
     */
    T selectOne(T query);

    /**
     * 查询集合
     *
     * @param query
     * @return
     */
    List<T> selectList(T query);
}
