package cn.penguin.provider.entity.authentic;

import cn.penguin.common.mybatis.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * (User)实体类
 *
 * @author wensy
 * @since 2022-11-26 11:02:58
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    /**
     * 账号
     */
    public String username;

    /**
     * 密码
     */
    public String password;

    /**
     * 姓名
     */
    public String realName;

    /**
     * 手机号码
     */
    public String mobile;

    /**
     * 1.锁定，0.禁用
     */
    public Integer isLocked;

    /**
     * 1.启用，0.禁用
     */
    public Integer isEnable;

    /**
     * 1.删除，0.正常
     */
    public Integer isDelete;


    /**
     * 最后更新时间
     */
    public LocalDateTime updateTime;

    public UserEntity(Long id, String username, String password, String realName, String mobile, Integer isLocked, Integer isEnable, Integer isDelete, LocalDateTime createTime, LocalDateTime updateTime) {
        super(id);
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.mobile = mobile;
        this.isLocked = isLocked;
        this.isEnable = isEnable;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


}

