package cn.penguin.provider.web.controller.authentic;

import cn.monitor4all.logRecord.annotation.OperationLog;
import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.constant.RedisConstant;
import cn.penguin.common.utils.IdUtil;
import cn.penguin.common.utils.RedisUtil;
import cn.penguin.provider.entity.authentic.UserDTO;
import cn.penguin.provider.service.authentic.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserDTO query(UserDTO query) {
        return userService.selectOne(query);
    }

    @GetMapping("/list")
    public List<UserDTO> list(UserDTO query){
        Long id = IdUtil.getId();
        List<UserDTO> list = null;
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
    @OperationLog(bizId = "#entity.id",bizType = "insert")
    public UserDTO save(@RequestBody UserDTO entity) {
        return userService.save(entity);
    }

    @PostMapping("/modify")
    @OperationLog(bizId = "#entity.id",bizType = "update")
    public Boolean modify(@RequestBody UserDTO entity) {
        return userService.update(entity);
    }
}
