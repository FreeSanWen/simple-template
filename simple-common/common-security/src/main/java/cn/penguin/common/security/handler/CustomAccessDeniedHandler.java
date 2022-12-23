package cn.penguin.common.security.handler;

import cn.penguin.common.core.enums.HttpEnum;
import cn.penguin.common.core.utils.JsonUtil;
import cn.penguin.common.core.vo.Reply;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 解决认证过的用户访问无权限资源时的异常
 *
 * @author wensy
 * @since 2022/12/23 15:23
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.getWriter().write(JsonUtil.toString(Reply.no(HttpEnum.TOKEN_EXPIRED)));
    }
}
