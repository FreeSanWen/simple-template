package cn.penguin.common.service;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 父类接口，定义常规方法
 *
 * @author wensy
 * @since 2022-11-27 17:02:58
 */
public interface IBaseService<T> {

    /**
     * 增加一条记录
     *
     * @param record
     * @return
     */
    T insert(T record);

    /**
     * 增加一条记录（非空字段)
     *
     * @param record
     * @return
     */
    T save(T record);

    /**
     * 批量增加记录
     *
     * @param record
     * @return
     */
    Boolean insertBatch(List<T> record);

    /**
     * 根据id删除记录
     *
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 根据id更新一条记录
     *
     * @param record
     * @return
     */
    Boolean modify(T record);

    /**
     * 根据id更新一条记录（非空字段）
     *
     * @param record
     * @return
     */
    Boolean update(T record);

    /**
     * 根据id查询一条记录
     *
     * @param id
     * @return
     */
    T selectById(Long id);

    /**
     * 查询一条记录
     *
     * @param query
     * @return
     */
    T selectOne(T query);

    /**
     * 查询多行记录
     *
     * @param query
     * @return
     */
    List<T> selectList(T query);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageInfo<T> selectPage(T query);

}
