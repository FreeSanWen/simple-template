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
        if (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).run();
        }
        return "provider-service：dict query by feign client";
    }
}
