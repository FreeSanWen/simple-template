package cn.penguin.common.security.handler;

import cn.penguin.common.core.enums.HttpEnum;
import cn.penguin.common.core.utils.JsonUtil;
import cn.penguin.common.core.vo.Reply;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * 解决匿名用户访问无权限资源时的异常
 *
 * @author wensy
 * @since 2022/12/1 10:39
 */
@Component
public class CustomLoginFailedHandler implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 1L;

    public CustomLoginFailedHandler() {
    }

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.getWriter().write(JsonUtil.toString(Reply.no(HttpEnum.FAIL)));
    }
}
