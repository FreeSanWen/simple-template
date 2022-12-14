package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.mybatis.service.impl.BaseService;
import cn.penguin.provider.domain.dto.authentic.User;
import cn.penguin.provider.mapper.authentic.UserMapper;
import cn.penguin.provider.service.authentic.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@Slf4j
@Service
public class UserService extends BaseService<UserMapper, User> implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
