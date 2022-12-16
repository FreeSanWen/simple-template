package cn.penguin.common.security.resolver;

import cn.penguin.common.core.constant.LogbackConstant;
import cn.penguin.common.security.annotation.CurrentUser;
import cn.penguin.common.security.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wensy
 * @since 2022/11/29 9:36
 */
@Slf4j
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //判断是否支持使用@CurrentUser注解的参数; 如果该参数注解有@CurrentUser且参数类型是User
        return parameter.getParameterAnnotation(CurrentUser.class) != null && parameter.getParameterType() == LoginUser.class ;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.info("{}注入user", LogbackConstant.LOG_PREFIX);
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return null;
    }
}
