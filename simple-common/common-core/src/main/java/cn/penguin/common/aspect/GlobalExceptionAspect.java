package cn.penguin.common.aspect;

import cn.penguin.common.constant.LogbackConstant;
import cn.penguin.common.entity.Reply;
import cn.penguin.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
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
}
