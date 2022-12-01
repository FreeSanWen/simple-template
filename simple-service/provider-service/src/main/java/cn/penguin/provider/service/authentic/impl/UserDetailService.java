package cn.penguin.provider.service.authentic.impl;

import cn.penguin.common.entity.LoginUser;
import cn.penguin.provider.entity.authentic.UserDTO;
import cn.penguin.provider.mapper.authentic.UserMapper;
import org.springframework.beans.BeanUtils;
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
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        UserDTO user = userMapper.selectOne(userDTO);
        LoginUser userDetails = new LoginUser();
        BeanUtils.copyProperties(user, userDetails);
        return userDetails;
    }

}
