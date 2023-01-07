package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.common.core.utils.ObjectUtil;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.provider.domain.entity.authentic.UserEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 用户信息表
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Data
@TableName("sys_user")
public class User extends UserEntity {

    private Role role;

    public static LoginUser convert(User user){
        LoginUser loginUser = new LoginUser();
        BeanUtils.copyProperties(user, loginUser);
        return loginUser;
    }

    @Override
    public Wrapper<User> wrapper() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (ObjectUtil.isNotEmpty(this.getUsername())) {
            lambdaQueryWrapper.eq(User::getUsername, this.getUsername());
        }
        if (ObjectUtil.isNotEmpty(this.getMobile())) {
            lambdaQueryWrapper.eq(User::getMobile, this.getMobile());
        }
        if (ObjectUtil.isNotEmpty(this.getRealName())) {
            lambdaQueryWrapper.eq(User::getRealName, this.getRealName());
        }
        return lambdaQueryWrapper;
    }
}
