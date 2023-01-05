package cn.penguin.provider.domain.dto.authentic;

import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.provider.domain.entity.authentic.UserEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 用户信息表
 *
 * @author wensy
 * @since 2022-11-27 1:24
 */
@Data
public class User extends UserEntity {

    @Builder
    public User(Long id, String username, String password, String realName, String mobile, String idNumber, Integer isLocked, Integer isEnable, Integer isDelete, Date createTime, Long creatorId, String creatorName, Date updateTime, Long updateId, String updateName) {
        super(id, username, password, realName, mobile, idNumber, isLocked, isEnable, isDelete, createTime, creatorId, creatorName, updateTime, updateId, updateName);
    }

    public static LoginUser convert(User user) {
        if (user == null) {
            return null;
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setId(user.getId());
        loginUser.setUsername(user.getUsername());
        loginUser.setPassword(user.getPassword());
        loginUser.setRealName(user.getRealName());
        loginUser.setMobile(user.getMobile());
        loginUser.setIsLocked(user.getIsLocked());
        loginUser.setIsEnable(user.getIsEnable());
        loginUser.setIsDelete(user.getIsDelete());
        return loginUser;
    }

    public User() {
    }
}
