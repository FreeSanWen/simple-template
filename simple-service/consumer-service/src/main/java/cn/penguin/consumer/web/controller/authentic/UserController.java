package cn.penguin.consumer.web.controller.authentic;

import cn.penguin.common.annotation.CurrentUser;
import cn.penguin.common.entity.LoginUser;
import cn.penguin.consumer.feign.ProviderFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final ProviderFeign providerFeign;

    @Autowired
    public UserController(ProviderFeign providerFeign) {
        this.providerFeign = providerFeign;
    }

    @GetMapping("/query")
    public String query(@RequestParam(value = "username")String username, @CurrentUser LoginUser loginUser) {
        Map map = new HashMap(2);
        map.put("username", username);
        return providerFeign.query(map);
    }
}
