package cn.penguin.common.web.aspect;

import cn.penguin.common.core.constant.LogbackConstant;
import cn.penguin.common.core.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wensy
 * @since 2022/11/24 16:20:00
 */
@Slf4j
@Aspect
@Component
public class HttpRequestAspect {

    @Pointcut("execution(* cn.penguin.*.web.controller..*.*(..)) || execution(* cn.penguin.*.web.feign..*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        List list = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof HttpServletRequest || arg instanceof HttpServletResponse || arg instanceof MultipartFile) {

            }else{
                list.add(arg);
            }
        }
        log.info("{}请求参数：{}", LogbackConstant.LOG_PREFIX, JsonUtil.toString(list));
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
}
