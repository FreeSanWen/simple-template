package cn.penguin.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@FeignClient(name = "provider-service",fallbackFactory = ProviderFeignFallback.class)
public interface ProviderFeign {

    /**
     * 查询用户
     *
     * @return
     */
    @GetMapping("/provider/feign/user/query")
    String query(@SpringQueryMap Map map);

    /**
     * 查询字典集合
     *
     * @return
     */
    @GetMapping("/provider/feign/dict/list")
    String list();
}
