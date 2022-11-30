package cn.penguin.common.aspect;

import cn.monitor4all.logRecord.context.LogRecordContext;
import cn.monitor4all.logRecord.function.CustomFunctionRegistrar;
import cn.penguin.common.annotation.RequireParam;
import cn.penguin.common.utils.ObjectUtil;
import cn.penguin.common.utils.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.Ordered;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wensy
 * @since 2022-11-22 11:38:00
 */
@Slf4j
@Aspect
@Component
public class RequireParamAspect implements Ordered {

    private final SpelExpressionParser parser = new SpelExpressionParser();

    private final DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();

    @Pointcut("@annotation(cn.penguin.common.annotation.RequireParam)")
    public void requireParams() {
    }

    @Before("requireParams()")
    public void doBefore(JoinPoint point) {
        //入参
        Object[] args = point.getArgs();
        if (Objects.isNull(args) || args.length == 0) {
            throw new RuntimeException("未设置校验参数！");
        }
        //获取注解
        RequireParam annotation = ObjectUtil.getAnnotation(point, RequireParam.class);

        String[] value = annotation.value();
        if (value.length < 1) {
            throw new RuntimeException("未设置校验参数！");
        }
        require(annotation, args, point);
    }

    private void require(RequireParam requireParams, Object[] args, JoinPoint point) {
        String[] valuesSpEL = requireParams.value();
        Method method = ObjectUtil.getMethod(point);
        String[] params = discoverer.getParameterNames(method);
        //定义合适map的初始大小，减少扩容次数
        int total = params.length;
        int size = ValidateUtil.tableSizeFor(total);
        //如果校验数量大于初始阈值，让容量扩大一倍
        if ((size * 0.75) < total) {
            size = size << 1;
        }
        Map map = new HashMap<>(size);
        StandardEvaluationContext context = LogRecordContext.getContext();
        CustomFunctionRegistrar.register(context);
        if (params != null) {
            for (int len = 0; len < params.length; len++) {
                context.setVariable(params[len], args[len]);
            }
        }
        if (ObjectUtil.isNotEmpty(valuesSpEL)) {
            for (int i = 0; i < valuesSpEL.length; i++) {
                String param = valuesSpEL[i];
                Expression bizIdExpression = parser.parseExpression(param);
                Object value = bizIdExpression.getValue(context, Object.class);
                map.put(param, value);
            }
        }
        ValidateUtil.verifyParam(map);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
