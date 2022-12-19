package cn.penguin.common.web.aspect;


import cn.penguin.common.core.utils.IdUtil;
import cn.penguin.common.security.entity.LoginUser;
import cn.penguin.common.core.utils.ObjectUtil;
import cn.penguin.common.security.utils.SecurityUtil;
import cn.penguin.common.web.annotation.BusinessLog;
import cn.penguin.common.web.entity.LogRecord;
import cn.penguin.common.web.enums.BusinessModuleEnum;
import cn.penguin.common.web.enums.BusinessOperationEnum;
import cn.penguin.common.web.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author wensy
 * @since 2022/12/1 14:39
 */
@Slf4j
@Aspect
@Component
public class BusinessLogAspect {

    private final SpelExpressionParser parser = new SpelExpressionParser();

    private final DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();

    private final ILogService logService;

    @Autowired
    public BusinessLogAspect(ILogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(cn.penguin.common.web.annotation.BusinessLog)")
    public void businessLog() {
    }

    @Around("businessLog()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        LogRecord logRecord = new LogRecord();
        Object result = null;
        try {
            result = joinPoint.proceed();
            logRecord.setIsSuccess(1);
            logRecord.setResult(result);
        } catch (Throwable e) {
            logRecord.setIsSuccess(0);
            logRecord.setResult(e);
        }
        LoginUser user = SecurityUtil.getUser();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 构建日志对象
                buildLog(joinPoint, logRecord, user);
            }
        }).start();

        if (Integer.valueOf(0).equals(logRecord.getIsSuccess())) {
            throw new Throwable((Throwable) logRecord.getResult());
        }
        return result;
    }

    private void buildLog(ProceedingJoinPoint joinPoint, LogRecord logRecord, LoginUser user) {
        //获取注解
        BusinessLog annotation = ObjectUtil.getAnnotation(joinPoint, BusinessLog.class);
        String bizIdSpEL = annotation.bizId();
        BusinessModuleEnum module = annotation.module();
        BusinessOperationEnum type = annotation.type();

        //获取业务主键
        StandardEvaluationContext context = new StandardEvaluationContext();
        Object[] args = joinPoint.getArgs();

        Method method = ObjectUtil.getMethod(joinPoint);
        String[] params = discoverer.getParameterNames(method);
        Object[] argsTemp = new Object[args.length];
        if (params != null) {
            for (int len = 0; len < params.length; len++) {
                Object arg = args[len];
                if (arg instanceof HttpServletRequest || arg instanceof HttpServletResponse || arg instanceof MultipartFile) {

                }else {
                    context.setVariable(params[len], arg);
                    argsTemp[len] = arg;
                }
            }
        }
        Expression bizIdExpression = parser.parseExpression(bizIdSpEL);
        Long value = bizIdExpression.getValue(context, Long.class);

        logRecord.setId(IdUtil.nextId());
        logRecord.setModule(module.getCode());
        logRecord.setOperationType(type.getCode());
        logRecord.setParams(argsTemp);
        logRecord.setRelationId(value);
        if (Objects.nonNull(user)) {
            logRecord.setCreatorId(user.getId());
            logRecord.setCreatorName(user.getRealName());
        }
        // 持久化日志
        logService.saveLog(logRecord);
    }
}
