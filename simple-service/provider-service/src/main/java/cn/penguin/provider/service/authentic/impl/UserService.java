package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.service.impl.BaseService;
import cn.penguin.provider.entity.authentic.User;
import cn.penguin.provider.mapper.authentic.UserMapper;
import cn.penguin.provider.repository.authentic.UserRepository;
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
public class UserService extends BaseService<User> implements IUserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserMapper userMapper, UserRepository userRepository) {
        super(userMapper);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
}
