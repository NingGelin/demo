package com.example.demo.aspect;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 日志切面配置
 *
 * @author chenglu
 * @date 2020-03-27
 **/

@Aspect
@Component
public class WebLogAspect
{
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 换行符
     */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 以自定义 @WebLog 注解为切点
     */
    @Pointcut("@annotation(com.example.demo.aspect.WebLog)")
    public void webLog()
    {
    }

    /**
     * 切点之前
     *
     * @param joinPoint 切点
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)
    {
        // 开始打印请求日志
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // 请求参数
        LOGGER.info("------------------------------------- Start ---------------------------------------");
        // 打印调用 controller 的全路径以及执行方法
        LOGGER.info("Class Method    : {}.{}, Request Params  : {}", joinPoint.getTarget().getClass().getName(),
                signature.getName(), new Gson().toJson(joinPoint.getArgs()));
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint xx
     * @return Object
     * @throws Throwable 异常
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 打印出参 执行耗时
        LOGGER.info("Response Params : {}, Cost Time : {} ms", new Gson().toJson(result),
                System.currentTimeMillis() - startTime);
        return result;
    }

    /**
     * 在切点之后
     */
    @After("webLog()")
    public void doAfter()
    {
        // 接口结束后换行，方便分割查看
        LOGGER.info("------------------------------------- End ---------------------------------------" + LINE_SEPARATOR);
    }
}
