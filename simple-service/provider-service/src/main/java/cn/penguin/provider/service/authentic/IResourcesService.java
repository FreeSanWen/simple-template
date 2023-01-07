package cn.penguin.provider.service.authentic;

import cn.penguin.common.mybatis.service.IBaseService;
import cn.penguin.provider.domain.dto.authentic.Resources;

import java.util.List;

public interface IResourcesService extends IBaseService<Resources> {

    /**
     * 获取当前用户对应的菜单列表
     *
     * @return
     */
    List<Resources> initMenuList();
}
