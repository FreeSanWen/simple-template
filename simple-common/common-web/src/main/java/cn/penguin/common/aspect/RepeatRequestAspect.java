package cn.penguin.common.aspect;

import cn.penguin.common.annotation.RepeatRequest;
import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.exception.BizException;
import cn.penguin.common.utils.JsonUtil;
import cn.penguin.common.utils.ObjectUtil;
import cn.penguin.common.utils.RedisUtil;
import com.alibaba.nacos.common.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wensy
 * @since 2022/12/1 1:36
 */
@Slf4j
@Aspect
@Component
public class RepeatRequestAspect {

    @Pointcut("@annotation(cn.penguin.common.annotation.RepeatRequest)")
    public void repeatRequest() {
    }

    @Before("repeatRequest()")
    public void before(JoinPoint point){
        //入参
        Object[] args = point.getArgs();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //这里是唯一标识 根据情况而定
        String key = ObjectUtil.getIpAddr(request) + request.getRequestURI() + JsonUtil.toString(args);
        String hex = MD5Utils.md5Hex(key, "UTF-8");
        if (RedisUtil.containsKey(hex)) {
            throw new BizException("请勿重复提交或者操作过于频繁！");
        } else {
            log.info("{}设置重复请求标签", LogbackConstant.LOG_PREFIX);
            RepeatRequest annotation = ObjectUtil.getAnnotation(point, RepeatRequest.class);
            RedisUtil.set(hex, 1, Integer.valueOf(annotation.time()), annotation.unit());
        }
    }
}
