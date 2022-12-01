package cn.penguin.provider.web.controller.authentic;

import cn.penguin.common.annotation.BusinessLog;
import cn.penguin.common.annotation.RequireParam;
import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.constant.RedisConstant;
import cn.penguin.common.enums.BusinessModuleEnum;
import cn.penguin.common.enums.BusinessOperationEnum;
import cn.penguin.common.utils.IdUtil;
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
    public UserController( IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/query")
    @RequireParam("#query.username")
    public User query(User query) {
        return userService.selectOne(query);
    }

    @GetMapping("/list")
    public List<User> list(User query){
        Long id = IdUtil.getId();
        List<User> list = null;
        Boolean lock = RedisUtil.lock(RedisConstant.USER_LOCK, id);
        if (lock) {
            log.info("{}获得锁", LogbackConstant.LOG_PREFIX);
            try{
                //加锁成功，
                list = userService.selectList(query);
            } finally {
                //解锁
                RedisUtil.releaseLock(RedisConstant.USER_LOCK, id);
            }
        }else{
            log.info("{}获取锁失败", LogbackConstant.LOG_PREFIX);
            //这里可以选择重试
        }
        return list;
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
