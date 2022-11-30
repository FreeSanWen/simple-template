package cn.penguin.common.filter;

import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Slf4j
@Component
public class HttpFilter extends OncePerRequestFilter implements Ordered {

    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            setLog(request, response, LogbackConstant.TRACE_ID);
            log.info("{}请求开始，url：【{}】", LogbackConstant.LOG_PREFIX, request.getRequestURL());
            filterChain.doFilter(request, response);
            stopWatch.stop();
            log.info("{}请求结束，耗时：{}秒!", LogbackConstant.LOG_PREFIX, stopWatch.getTotalTimeSeconds());
        } finally {
            MDC.clear();
        }

    }

    /**
     * 设置traceId
     *
     * @param request
     * @param response
     * @param trace
     */
    private void setLog(HttpServletRequest request, HttpServletResponse response, String trace) {

        String traceId = request.getHeader(trace);
        if (ObjectUtils.isEmpty(traceId)) {
            traceId = IdUtil.getIdStr();
        }
        MDC.put(trace, traceId);
        response.addHeader(trace, traceId);
    }
}
