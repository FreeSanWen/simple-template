package cn.penguin.provider.mapper.authentic;


import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.provider.domain.dto.authentic.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wensy
 * @since 2022-11-26 11:02:58
 */
@Mapper
public interface UserMapper extends GenericMapper<User> {


    /**
     * 根据用户名获取用户对象，并带上当前角色对象
     *
     * @param username
     * @return
     */
    User loadUserByUsername(@Param("username") String username);
}
