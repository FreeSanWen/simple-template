package cn.penguin.provider.mapper.authentic;

import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.provider.domain.dto.authentic.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wensy
 * @since 2022/12/27 9:54
 */
@Mapper
public interface ResourcesMapper extends GenericMapper<Resources> {

    /**
     * 根据角色获取接口权限集合
     *
     * @param roleId
     * @return
     */
    List<Resources> selectListByRole(@Param("roleId") Long roleId,@Param("type") Integer type);
}
