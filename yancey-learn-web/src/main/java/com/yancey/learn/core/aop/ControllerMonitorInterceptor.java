package com.yancey.learn.core.aop;

import com.google.common.collect.Maps;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author jianhong.li Data: 2017-12-10 Time: 1:19 PM
 * @version $Id$
 */
@Aspect
@Component
public class ControllerMonitorInterceptor {

    /**
     * 日志输出
     */
    private static final Logger logger = LoggerFactory.getLogger(ControllerMonitorInterceptor.class);

    @Pointcut("execution(* com.yancey.learn.controller.*Controller.*(..))")
    public void controllerMonitor() {
    }

    private Map<Object, String> keyMap = Maps.newConcurrentMap();


    /***
     * 监控每一个方法处理时间
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && controllerMonitor()")
    public Object monitorControllerHandle(ProceedingJoinPoint pjp) throws Throwable {
        long timeStart = System.currentTimeMillis();
        String monitorKey = getMonitorKey(pjp);
        try {
            return pjp.proceed();
        } finally {
            long timeConsume = System.currentTimeMillis() - timeStart;
            logger.debug("******ControllerMonitorInterceptor（monitorControllerHandle）******monitorKey:{},mis:{}",
                    monitorKey, timeConsume);
//            TMonitor.recordOne(monitorKey, timeConsume);
        }

    }


    @AfterThrowing(throwing = "ex", pointcut = "@annotation(org.springframework.web.bind.annotation.RequestMapping) && controllerMonitor()")
    public void monitorControllerHandleException(JoinPoint jp, Throwable ex) throws Throwable {

        String shotSig = jp.getSignature().toShortString();
        String monitorKey = keyMap.get(shotSig);

        if (monitorKey == null) {
            monitorKey = jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName();
            keyMap.put(jp.getSignature().toShortString(), monitorKey);
        }
        logger.error("******ControllerMonitorInterceptor（monitorControllerHandleException）******shotSig:{},ex:{}",
                shotSig, ex);
//        TMonitor.recordOne(monitorKey + "_Exception");
    }


    private String getMonitorKey(ProceedingJoinPoint pjp) {
        if (pjp == null) {
            return Strings.EMPTY;
        }
        String key = keyMap.get(pjp.getSignature().toShortString());
        if (key == null) {
            key = pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName();
            keyMap.put(pjp.getSignature().toShortString(), key);
        }
        return key;
    }


    /**
     * 获取被拦截方法对象
     * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象
     * 而缓存的注解在实现类的方法上
     * 所以应该使用反射获取当前对象的方法对象
     */
    public Method getMethod(ProceedingJoinPoint pjp) {
        //获取参数的类型
        Method method = null;
        try {
            Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getMethod().getParameterTypes();
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), parameterTypes);
        } catch (Exception e) {
            String errorInfo = pjp + "_" + e.getMessage();
            logger.error(errorInfo, e);
        }
        return method;
    }
}
