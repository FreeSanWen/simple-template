package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.core.utils.TreeUtil;
import cn.penguin.common.mybatis.service.impl.BaseService;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.common.security.utils.SecurityUtil;
import cn.penguin.provider.domain.dto.authentic.Resources;
import cn.penguin.provider.mapper.authentic.ResourcesMapper;
import cn.penguin.provider.service.authentic.IResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ResourcesService extends BaseService<ResourcesMapper, Resources> implements IResourcesService {

    private final ResourcesMapper resourcesMapper;

    @Autowired
    public ResourcesService(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
    }

    @Override
    public List<Resources> initMenuList() {
        LoginUser user = SecurityUtil.getUser();
        List<Resources> resources = resourcesMapper.selectListByRole(user.getRoleId(),1);
        List<Resources> list = TreeUtil.create(resources, Resources::getId, Resources::getParentId, Resources::setChildList, s -> Long.valueOf(0).equals(s));
        return list;
    }
}
