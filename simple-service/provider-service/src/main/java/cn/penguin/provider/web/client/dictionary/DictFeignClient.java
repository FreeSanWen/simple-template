package cn.penguin.provider.web.client.dictionary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wensy
 * @since 2022/11/27 1:28
 */
@RestController
@RequestMapping("/feign/dict")
public class DictFeignClient {

    @GetMapping("/query")
    public String query(){
        return "provider-service：dict query by feign client";
    }
}
