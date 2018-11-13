package com.saraad.common.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: LogAspect
 * @Package:com.saraad.common.aop
 * @Description:
 * @author: bin.peng
 * @date: 2018/11/716:14
 * @Copyright: 2018 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目的
 */

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.saraad.controller..*.*(..))")
    public void log(){}

    @Before("log()")
    public void beforeAct(JoinPoint joinPoint){
        // 获取当前请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("AOP:Before...");
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("ARGS : " + JSON.toJSONString(joinPoint.getArgs()));
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("请求参数:" + JSON.toJSONString(joinPoint.getArgs()));

    }

    //
    @After("log()")
    public void afterAct(){
        System.out.println("AOP:After...");
    }

    @AfterReturning(pointcut = "log()",returning = "obj")
    public void returnAct(Object obj){
        System.out.println("AOP:Return_返回值:"+JSON.toJSONString(obj));
    }

    @AfterThrowing(pointcut = "log()",throwing = "e")
    public void throwAct(Throwable e) throws Throwable{
        System.out.println("AOP:Throwing:捕获异常:"+e);
//        throw e;
    }

//    @Around("log()")
    public void aroundAct(ProceedingJoinPoint joinPoint) throws Exception{
        //获取当前执行的方法
        Signature signature = joinPoint.getSignature();
        if(!(signature instanceof MethodSignature))
            throw new Exception("该注解只能用于方法");
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        System.out.println("当前执行的方法为:"+method.getName());
    }






}
