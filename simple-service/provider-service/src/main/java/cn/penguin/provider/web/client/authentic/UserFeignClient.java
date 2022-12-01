package cn.penguin.provider.web.client.authentic;

import cn.penguin.common.annotation.CurrentUser;
import cn.penguin.common.entity.LoginUserEntity;
import cn.penguin.common.utils.JsonUtil;
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
    public String query(User query, @CurrentUser LoginUserEntity user){
        System.out.println(JsonUtil.toString(user));
        return "provider-service：user query by feign client";
    }
}
