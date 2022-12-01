package cn.penguin.gateway.filter;

import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class RequestFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        try {
            String traceId = IdUtil.getIdStr();
            MDC.put(LogbackConstant.TRACE_ID, traceId);
            //获取header
            ServerHttpRequest req = exchange.getRequest();
            RequestPath path = req.getPath();
            ServerHttpRequest.Builder requestBuilder = req.mutate();
            requestBuilder.headers(k -> k.remove(LogbackConstant.TRACE_ID));
            requestBuilder.header(LogbackConstant.TRACE_ID, traceId);
            //重新生成header
            ServerHttpRequest request = requestBuilder.build();
            exchange.mutate().request(request).build();
            log.info("{}请求：{}", LogbackConstant.LOG_PREFIX, path);
            return chain.filter(exchange);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
