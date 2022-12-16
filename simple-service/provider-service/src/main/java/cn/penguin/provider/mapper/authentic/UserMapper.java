package cn.penguin.provider.mapper.authentic;


import cn.penguin.common.mybatis.mapper.GenericMapper;
import cn.penguin.provider.entity.authentic.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wensy
 * @since 2022-11-26 11:02:58
 */
@Mapper
public interface UserMapper extends GenericMapper<User> {


}
