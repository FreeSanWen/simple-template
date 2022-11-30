package cn.penguin.common.mapper;

import java.util.List;

/**
 * 父类接口，定义常规方法
 *
 * @author wensy
 * @since 2022-11-27 11:02:58
 */
public interface BaseMapper<T> {

    /**
     * 增加一条记录
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 增加一条记录（非空字段)
     *
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 批量增加记录
     *
     * @param record
     * @return
     */
    int insertBatch(List<T> record);

    /**
     * 根据id删除记录
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据id更新一条记录
     *
     * @param record
     * @return
     */
    int updateById(T record);

    /**
     * 根据id更新一条记录（非空字段）
     *
     * @param record
     * @return
     */
    int updateSelectiveById(T record);

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





}
