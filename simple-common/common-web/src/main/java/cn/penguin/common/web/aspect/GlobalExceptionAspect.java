package cn.penguin.common.web.aspect;

import cn.penguin.common.core.constant.LogbackConstant;
import cn.penguin.common.core.enums.HttpEnum;
import cn.penguin.common.core.exception.BizException;
import cn.penguin.common.core.vo.Reply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAspect {

    @ExceptionHandler(Exception.class)
    public Reply exceptionHandler(Throwable throwable) throws Exception {
        log.error("{}全局异常，{}", LogbackConstant.LOG_PREFIX, throwable);
        return Reply.no(throwable);
    }

    @ExceptionHandler(BizException.class)
    public Reply bizExceptionHandler(BizException bizException) throws Exception {
        log.error("{}业务异常，{}", LogbackConstant.LOG_PREFIX, bizException);
        return Reply.no(bizException);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public Reply badCredentialsExceptionHandler(BadCredentialsException exception) throws Exception {
        log.error("{}用户名或密码错误，{}", LogbackConstant.LOG_PREFIX, exception);
        return Reply.no(HttpEnum.LOGIN_DENIED);
    }
}
