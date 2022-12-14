package cn.penguin.common.security.entity;

import cn.penguin.common.core.utils.CollectionsUtil;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wensy
 * @since 2022/12/1 9:56
 */
@Data
public class LoginUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 账号
     */
    private String username;

    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 1.锁定，0.禁用
     */
    private Integer isLocked;

    /**
     * 1.启用，0.禁用
     */
    private Integer isEnable;

    /**
     * 1.删除，0.正常
     */
    private Integer isDelete;

    /**
     * 登陆时间
     */
    private long loginTime;

    /**
     * 过期时间
     */
    private long expireTime;

    /**
     * token
     */
    private String token;

    /**
     * LoginEnum
     */
    private Integer checkType;
    /**
     * 当前角色id
     */
    private Long roleId;

    /**
     * 当前角色名称
     */
    private String roleName;

    /**
     * 接口权限集合
     */
    private List<String> permissionList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionsUtil.isNotEmpty(permissionList)) {
            List<SimpleGrantedAuthority> collect = permissionList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            return collect;
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        Integer isLocked = getIsLocked();
        return null != isLocked && isLocked == 0;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        Integer isEnable = getIsEnable();
        return null != isEnable && isEnable == 1;
    }
}
