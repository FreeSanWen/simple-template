package cn.penguin.provider.web.controller.authentic;

import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.common.web.annotation.RequireParam;
import cn.penguin.provider.service.authentic.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * @author wensy
 * @since 2022/11/28 21:58
 */
@RestController
@RequestMapping
public class LoginController {

    private final ILoginService loginService;

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/doLogin")
    @RequireParam({"#user.username","#user.password"})
    public Map<String,String> doLogin(@RequestBody LoginUser user) {
        return loginService.doLogin(user);
    }


}
