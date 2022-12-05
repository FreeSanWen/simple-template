package cn.penguin.provider.entity.authentic;

import cn.penguin.common.entity.LoginUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Getter
@Setter
@NoArgsConstructor
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
}
