package cn.penguin.common.handler;

import cn.penguin.common.entity.Reply;
import cn.penguin.common.enums.HttpEnum;
import cn.penguin.common.utils.JsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
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
        response.getWriter().write(JsonUtil.toString(Reply.no(HttpEnum.TOKEN_EXPIRED)));
    }
}
