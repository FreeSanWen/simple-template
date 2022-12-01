package cn.penguin.consumer.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@Slf4j
@Component
public class ProviderFeignFallback implements FallbackFactory<ProviderFeign> {

    @Override
    public ProviderFeign create(Throwable cause) {
        log.error("feign error ：{}", cause);
        return new ProviderFeign() {

            @Override
            public String query(Map map) {
                return "provider user query failed";
            }

            @Override
            public String list() {
                return "provider dict query failed";
            }
        };
    }
}