package cn.penguin.provider.web.client.authentic;

import cn.penguin.common.core.utils.JsonUtil;
import cn.penguin.common.security.annotation.CurrentUser;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.provider.entity.authentic.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@RestController
@RequestMapping("/feign/user")
public class UserFeignClient {

    @GetMapping("/query")
    public String query(User query, @CurrentUser LoginUser user){
        System.out.println(JsonUtil.toString(user));
        return "provider-service：user query by feign client";
    }
}
