package cn.penguin.provider.service.authentic.impl;

import cn.penguin.provider.domain.dto.authentic.User;
import cn.penguin.provider.mapper.authentic.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author wensy
 * @since 2022/12/1 11:07
 */
@Service
public class UserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        return User.convert(user);
    }

}
