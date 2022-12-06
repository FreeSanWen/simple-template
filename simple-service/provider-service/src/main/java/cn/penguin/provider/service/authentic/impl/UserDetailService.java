package cn.penguin.provider.service.authentic.impl;

import cn.penguin.provider.entity.authentic.User;
import cn.penguin.provider.mapper.authentic.UserMapper;
import cn.penguin.provider.repository.authentic.UserRepository;
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
    private final UserRepository userRepository;

    public UserDetailService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return User.convert(user);
    }

}
