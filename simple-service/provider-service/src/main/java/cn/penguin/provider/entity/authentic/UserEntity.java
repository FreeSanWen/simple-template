package cn.penguin.provider.entity.authentic;

import cn.penguin.common.entity.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

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
@Table("sys_user")
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
    @Transient
    public Integer isLocked;

    /**
     * 1.启用，0.禁用
     */
    @Transient
    public Integer isEnable;

    /**
     * 1.删除，0.正常
     */
    @Transient
    public Integer isDelete;

    /**
     * 创建时间
     */
    @Transient
    public LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    @Transient
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

