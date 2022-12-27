package cn.penguin.provider.entity.authentic;

import cn.penguin.common.core.utils.ObjectUtil;
import cn.penguin.common.security.entity.LoginUser;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * 用户信息表
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_user")
public class User extends UserEntity {

    @Builder(toBuilder = true)
    public User(Long id,String username, String password, String realName, String mobile, Integer isLocked, Integer isEnable, Integer isDelete, LocalDateTime createTime, LocalDateTime updateTime) {
        super(id, username, password, realName, mobile, isLocked, isEnable, isDelete, createTime, updateTime);
    }

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
