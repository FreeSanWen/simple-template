package cn.penguin.common.utils;

import cn.penguin.common.constant.IpConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author wensy
 * @since 2022-11-26 14:55
 */
@Slf4j
public class ObjectUtil extends ObjectUtils {
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 获取方法，适用于 aop
     *
     * @param joinPoint
     * @return
     */
    public static Method getMethod(JoinPoint joinPoint) {
        Method method = null;
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature ms = (MethodSignature) signature;
            Object target = joinPoint.getTarget();
            method = target.getClass().getMethod(ms.getName(), ms.getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("OperationLogAspect getMethod error", e);
        }
        return method;
    }

    /**
     * 获取注解，适用于aop
     *
     * @param point
     * @param annotationClass
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T getAnnotation(JoinPoint point, Class<T> annotationClass) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(annotationClass);
    }

    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return IpConstant.UNKNOWN;
        }
        String ip = request.getHeader(IpConstant.X_FORWARDED_FOR);
        if (ip == null || ip.length() == 0 || IpConstant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IpConstant.PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || IpConstant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IpConstant.X_FORWARDED_FOR_UP);
        }
        if (ip == null || ip.length() == 0 || IpConstant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IpConstant.WL_PROXY_CLIENT_IP);
        }
        if (ip == null || ip.length() == 0 || IpConstant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IpConstant.X_REAL_IP);
        }
        if (ip == null || ip.length() == 0 || IpConstant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return IpConstant.IPV6.equals(ip) ? IpConstant.IPV4 : ip;
    }
}
