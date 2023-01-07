package cn.penguin.provider.mapper.authentic;

import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.provider.domain.dto.authentic.Resources;
import cn.penguin.provider.domain.dto.authentic.Role;

import java.util.List;

/**
 * @author wensy
 * @since 2022/12/27 9:54
 */
public interface ResourcesMapper extends GenericMapper<Resources> {

    /**
     * 根据角色获取接口权限集合
     *
     * @param role
     * @return
     */
    List<Resources> selectListByRole(Role role);
}
