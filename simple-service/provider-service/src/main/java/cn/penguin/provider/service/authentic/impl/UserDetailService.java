package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.core.utils.CollectionsUtil;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.provider.domain.dto.authentic.Resources;
import cn.penguin.provider.domain.dto.authentic.Role;
import cn.penguin.provider.domain.dto.authentic.User;
import cn.penguin.provider.mapper.authentic.ResourcesMapper;
import cn.penguin.provider.mapper.authentic.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wensy
 * @since 2022/12/1 11:07
 */
@Service
public class UserDetailService implements UserDetailsService {

    private final UserMapper userMapper;
    private final ResourcesMapper resourcesMapper;

    public UserDetailService(UserMapper userMapper, ResourcesMapper resourcesMapper) {
        this.userMapper = userMapper;
        this.resourcesMapper = resourcesMapper;
    }

    /**
     * 获取用户对象
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        LoginUser loginUser = User.convert(user);
        //获取权限集合
        Role role = user.getRole();
        if (Objects.nonNull(role)) {
            loginUser.setRoleId(role.getId());
            loginUser.setRoleName(role.getRoleName());
            List<Resources> resourcesList = resourcesMapper.selectListByRole(role);
            if (CollectionsUtil.isNotEmpty(resourcesList)) {
                loginUser.setPermissionList(resourcesList.stream().map(Resources::getResourcesName).collect(Collectors.toList()));
            }
        }
        return loginUser;
    }
}
