package cn.penguin.provider.service.dictionary;

import cn.penguin.common.service.IBaseService;
import cn.penguin.provider.entity.dictionary.Dict;

import java.util.List;

/**
 * @author Wensy
 * @since 2022/11/27 17:51:00
 */
public interface IDictService extends IBaseService<Dict, Long> {

    /**
     * 查询单行记录
     *
     * @param query 查询条件
     * @return UserDTO
     */
    Dict selectOne(Dict query);

    /**
     * 查询多行记录
     *
     * @param query 查询条件
     * @return List<UserDTO>
     */
    List<Dict> selectList(Dict query);

    /**
     * 保存一条记录
     *
     * @param entity 实体
     * @return UserDTO
     */
    Dict save(Dict entity);

    /**
     * 更新一条记录
     *
     * @param entity 实体
     * @return UserDTO
     */
    Boolean update(Dict entity);
}
