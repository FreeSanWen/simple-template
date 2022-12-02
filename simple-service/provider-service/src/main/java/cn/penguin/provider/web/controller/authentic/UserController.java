package cn.penguin.provider.web.controller.authentic;

import cn.penguin.common.annotation.BusinessLog;
import cn.penguin.common.annotation.RequireParam;
import cn.penguin.common.constant.RedisConstant;
import cn.penguin.common.enums.BusinessModuleEnum;
import cn.penguin.common.enums.BusinessOperationEnum;
import cn.penguin.common.utils.RedisUtil;
import cn.penguin.provider.entity.authentic.User;
import cn.penguin.provider.service.authentic.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Wensy
 * @since 2022/11/24 16:28:00
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/query")
    @RequireParam("#query.username")
    public User query(User query) {
        return userService.selectOne(query);
    }

    @GetMapping("/list")
    public List<User> list(User query){
        //优化后
        return RedisUtil.lock(RedisConstant.USER_LOCK, s -> userService.selectList(s), query);
    }

    @PostMapping("/save")
    @RequireParam("#entity.username")
    @BusinessLog(bizId = "#entity.id", module = BusinessModuleEnum.USER_MODULE, type = BusinessOperationEnum.INSERT)
    public User save(@RequestBody User entity, HttpServletRequest request) {
        return userService.save(entity);
    }

    @PostMapping("/modify")
    public Boolean modify(@RequestBody User entity) {
        return userService.update(entity);
    }
}
