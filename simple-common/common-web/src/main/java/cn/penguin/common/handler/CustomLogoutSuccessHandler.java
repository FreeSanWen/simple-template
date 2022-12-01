package cn.penguin.common.handler;

import cn.penguin.common.entity.LoginUser;
import cn.penguin.common.entity.Reply;
import cn.penguin.common.enums.HttpEnum;
import cn.penguin.common.utils.JsonUtil;
import cn.penguin.common.utils.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author wensy
 * @since 2022/12/1 10:40
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginUser loginUser = SecurityUtil.getUser(request, false);
        if (Objects.nonNull(loginUser)) {
            SecurityUtil.delete(loginUser);
        }
        response.getWriter().write(JsonUtil.toString(Reply.ok(HttpEnum.SUCCESS)));
    }
}
