package cn.penguin.common.web.interceptor;

import cn.penguin.common.core.constant.LogbackConstant;
import cn.penguin.common.core.constant.SecurityConstant;
import cn.penguin.common.security.utils.SecurityUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Slf4j
@Component
public class OpenFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //将当前服务的traceId放到header中，形成单次请求全链路统一
        String traceId = MDC.get(LogbackConstant.TRACE_ID);
        requestTemplate.header(LogbackConstant.TRACE_ID, traceId);
        log.info("{}调用feign请求", LogbackConstant.LOG_PREFIX);
        //设置token
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        requestTemplate.header(SecurityConstant.AUTHORIZATION, SecurityUtil.getToken(request));
    }
}
