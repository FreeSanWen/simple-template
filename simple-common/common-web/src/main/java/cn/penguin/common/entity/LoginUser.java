package cn.penguin.common.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author wensy
 * @since 2022/12/1 9:56
 */
@Data
public class LoginUser extends LoginUserInfo implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
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
