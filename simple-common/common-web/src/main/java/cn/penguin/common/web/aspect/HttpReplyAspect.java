package cn.penguin.common.web.aspect;

import cn.penguin.common.core.utils.JsonUtil;
import cn.penguin.common.core.vo.Reply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Slf4j
@RestControllerAdvice
public class HttpReplyAspect implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !Reply.class.getName().equals(returnType.getParameterType().getName());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            return JsonUtil.toString(Reply.ok(body));
        }
        return Reply.ok(body);
    }
}
